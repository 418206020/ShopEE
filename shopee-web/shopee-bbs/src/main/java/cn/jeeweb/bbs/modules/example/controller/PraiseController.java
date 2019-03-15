package cn.shopee.bbs.modules.example.controller;

import cn.shopee.bbs.common.bean.ResponseError;
import cn.shopee.bbs.modules.example.service.IPraiseService;
import cn.shopee.bbs.modules.example.entity.Praise;
import cn.shopee.common.http.PageResponse;
import cn.shopee.common.http.Response;
import cn.shopee.common.mvc.controller.BaseBeanController;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.query.annotation.PageableDefaults;
import cn.shopee.common.query.data.PropertyPreFilterable;
import cn.shopee.common.query.data.Queryable;
import cn.shopee.common.query.utils.QueryableConvertUtils;
import cn.shopee.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.example.controller
 * @title: 点赞控制器
 * @description: 点赞控制器
 * @author: HuLiang
 * @date: 2018-09-04 16:46:49
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("praise")
public class PraiseController extends BaseBeanController<Praise> {

    @Autowired
    private IPraiseService praiseService;


    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return display("list");
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<Praise> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Praise> pagejson = new PageResponse<>(praiseService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    @PostMapping("add")
    public Response add(Praise entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public Response update(Praise entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public Response doSave(Praise entity, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                return Response.error(ResponseError.NORMAL_ERROR,errorMsg);
            } else {
                return Response.error(ResponseError.NORMAL_ERROR,"保存失败");
            }
        }
        try {
            if (StringUtils.isEmpty(entity.getId())) {
                praiseService.insert(entity);
            } else {
                praiseService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return Response.ok("保存成功");
    }

    @GetMapping("{id}/delete")
    public Response delete(@PathVariable("id") String id) {
        try {
            praiseService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return Response.ok("删除成功");
    }


}