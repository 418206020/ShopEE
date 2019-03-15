package cn.shopee.bbs.modules.sys.controller;

import cn.shopee.bbs.aspectj.annotation.Log;
import cn.shopee.bbs.aspectj.enums.LogType;
import cn.shopee.bbs.common.bean.ResponseError;
import cn.shopee.bbs.modules.sys.service.IOperationLogService;
import cn.shopee.bbs.modules.sys.entity.OperationLog;
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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.sys.controller
 * @title: 操作日志控制器
 * @description: 操作日志控制器
 * @author: HuLiang
 * @date: 2018-09-30 15:53:25
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("${shopee.admin.url.prefix}/sys/operation/log")
@ViewPrefix("modules/sys/log")
@RequiresPathPermission("sys:operation:log")
@Log(title = "操作日志")
public class OperationLogController extends BaseBeanController<OperationLog> {

    @Autowired
    private IOperationLogService operationLogService;


    @GetMapping
    @RequiresMethodPermissions("view")
	public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
		return displayModelAndView("operation_list");
	}

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<OperationLog> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<OperationLog> pagejson = new PageResponse<>(operationLogService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

	@PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
	public Response delete(@PathVariable("id") String id) {
	    operationLogService.deleteById(id);
		return Response.ok("删除成功");
	}

    @GetMapping("{id}/detail")
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("detail")
    public ModelAndView detail(Model model,@PathVariable("id") String id) {
        OperationLog operationLog = operationLogService.selectById(id);
        model.addAttribute("operationLog", operationLog);
        return displayModelAndView("operation_detail");
    }

	@PostMapping("batch/delete")
   // @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
	public Response batchDelete(@RequestParam("ids") String[] ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		operationLogService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}
}