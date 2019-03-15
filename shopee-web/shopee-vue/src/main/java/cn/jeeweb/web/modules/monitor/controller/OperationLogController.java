package cn.shopee.web.modules.monitor.controller;

import cn.shopee.common.http.Response;
import cn.shopee.common.mvc.annotation.ViewPrefix;
import cn.shopee.common.mvc.controller.BaseBeanController;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.shopee.common.security.shiro.authz.annotation.RequiresPathPermission;
import cn.shopee.common.utils.FastJsonUtils;
import cn.shopee.web.aspectj.annotation.Log;
import cn.shopee.web.aspectj.enums.LogType;
import cn.shopee.web.modules.monitor.entity.OperationLog;
import cn.shopee.web.modules.monitor.service.IOperationLogService;
import cn.shopee.web.utils.PageRequest;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.web.modules.sys.controller
 * @title: 操作日志控制器
 * @description: 操作日志控制器
 * @author: HuLiang
 * @date: 2018-09-30 15:53:25
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("monitor/operation/log")
@ViewPrefix("modules/sys/log")
@RequiresPathPermission("monitor:operation:log")
@Log(title = "操作日志")
public class OperationLogController extends BaseBeanController<OperationLog> {

    @Autowired
    private IOperationLogService operationLogService;

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @throws IOException
     */
    @GetMapping(value = "list")
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void list( HttpServletRequest request) throws IOException {
        //加入条件
        EntityWrapper<OperationLog> entityWrapper = new EntityWrapper<>(OperationLog.class);
        entityWrapper.orderBy("createDate",false);

        // 预处理
        Page pageBean = operationLogService.selectPage(PageRequest.getPage(),entityWrapper);
        FastJsonUtils.print(pageBean);
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
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
	public Response batchDelete(@RequestParam("ids") String[] ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		operationLogService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}
}