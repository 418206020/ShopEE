package cn.shopee.bbs.modules.sys.mapper;

import cn.shopee.bbs.modules.sys.entity.MessageTemplate;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.sys.mapper
 * @title: 消息模版数据库控制层接口
 * @description: 消息模版数据库控制层接口
 * @author: HuLiang
 * @date: 2018-09-03 15:10:10
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@Mapper
public interface MessageTemplateMapper extends BaseMapper<MessageTemplate> {
    
}