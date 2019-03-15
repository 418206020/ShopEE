package cn.shopee.bbs.modules.front.controller;

import cn.shopee.bbs.common.bean.ResponseError;
import cn.shopee.bbs.modules.sys.entity.Message;
import cn.shopee.bbs.modules.sys.service.IMessageService;
import cn.shopee.bbs.utils.UserUtils;
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
import java.util.List;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.sys.controller
 * @title: 系统消息控制器
 * @description: 系统消息控制器
 * @author: HuLiang
 * @date: 2018-09-03 15:10:32
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */

@RestController("FrontMessageController")
@RequestMapping("message")
public class MessageController extends BaseBeanController<Message> {

    @Autowired
    private IMessageService messageService;

    @PostMapping("unReadNums")
    public Response unReadNums() {
        Response response = Response.ok("删除成功");
        EntityWrapper<Message> entityWrapper = new EntityWrapper<Message>(Message.class);
        entityWrapper.eq("read",0);
        entityWrapper.eq("readUid",UserUtils.getUser().getId());
        int count = messageService.selectCount(entityWrapper);
        response.put("count",count);
        return response;
    }

    /**
     * 全部已读
     * @return
     */
    @PostMapping("read")
    public Response read() {
        EntityWrapper<Message> entityWrapper = new EntityWrapper<Message>(Message.class);
        entityWrapper.eq("read",0);
        entityWrapper.eq("readUid",UserUtils.getUser().getId());
        List<Message> messageList = messageService.selectList(entityWrapper);
        for (Message message: messageList) {
            message.setRead(1);
            messageService.insertOrUpdate(message);
        }
        return Response.ok("更新成功");
    }

    @PostMapping("remove")
    public Response remove(@RequestParam(value = "id",required = false) String id) {
        try {
            if (StringUtils.isEmpty(id)){
                EntityWrapper<Message> entityWrapper = new EntityWrapper<Message>(Message.class);
                entityWrapper.eq("readUid",UserUtils.getUser().getId());
                messageService.delete(entityWrapper);
            }else{
                messageService.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"清空失败");
        }
        return Response.ok("清空成功");
    }


}