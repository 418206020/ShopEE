package cn.shopee.web.modules.sms.controller;

import cn.shopee.common.utils.FastJsonUtils;
import cn.shopee.web.aspectj.annotation.Log;
import cn.shopee.web.aspectj.enums.LogType;
import cn.shopee.web.modules.sms.entity.SmsTemplate;
import cn.shopee.web.modules.sms.service.ISmsTemplateService;
import cn.shopee.common.http.PageResponse;
import cn.shopee.common.http.Response;
import cn.shopee.common.mvc.annotation.ViewPrefix;
import cn.shopee.common.mvc.controller.BaseBeanController;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.query.annotation.PageableDefaults;
import cn.shopee.common.query.data.PropertyPreFilterable;
import cn.shopee.common.query.data.Queryable;
import cn.shopee.common.query.utils.QueryableConvertUtils;
import cn.shopee.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.shopee.common.security.shiro.authz.annotation.RequiresPathPermission;
import cn.shopee.common.utils.StringUtils;
import cn.shopee.web.utils.PageRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.web.modules.sms.controller
 * @title: 短信模板控制器
 * @description: 短信模板控制器
 * @author: HuLiang
 * @date: 2018-09-14 09:47:35
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("sms/template")
@RequiresPathPermission("sms:template")
@ViewPrefix("modules/sms/template")
@Log(title = "短信模板")
public class SmsTemplateController extends BaseBeanController<SmsTemplate> {

    @Autowired
    private ISmsTemplateService smsTemplateService;


    @GetMapping(value = "list")
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void list( HttpServletRequest request) throws IOException {
        //加入条件
        EntityWrapper<SmsTemplate> entityWrapper = new EntityWrapper<>(SmsTemplate.class);
        entityWrapper.orderBy("createDate",false);
        String code= request.getParameter("code");
        if (!StringUtils.isEmpty(code)){
            entityWrapper.like("code",code);
        }
        String name=request.getParameter("name");
        if (!StringUtils.isEmpty(name)){
            entityWrapper.like("name",name);
        }
        // 预处理
        Page pageBean = smsTemplateService.selectPage(PageRequest.getPage(),entityWrapper);
        FastJsonUtils.print(pageBean,SmsTemplate.class,"id,name,code,businessType,templateContent");
    }

    @PostMapping("add")
    @Log(logType = LogType.INSERT)
    @RequiresMethodPermissions("add")
    public Response add(SmsTemplate entity, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        String templateCode = StringUtils.randomString(10);
        entity.setCode(templateCode);
        smsTemplateService.insert(entity);
        return Response.ok("添加成功");
    }

    @PostMapping("{id}/update")
    @Log(logType = LogType.UPDATE)
    @RequiresMethodPermissions("update")
    public Response update(SmsTemplate entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        smsTemplateService.insertOrUpdate(entity);
        return Response.ok("更新成功");
    }

    @PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response delete(@PathVariable("id") String id) {
        smsTemplateService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping("batch/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        smsTemplateService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }
}