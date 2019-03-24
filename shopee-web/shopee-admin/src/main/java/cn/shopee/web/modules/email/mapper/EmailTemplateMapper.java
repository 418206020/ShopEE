package cn.shopee.web.modules.email.mapper;

import cn.shopee.web.modules.email.entity.EmailTemplate;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.email.mapper
* @title: 邮件模板数据库控制层接口
* @description: 邮件模板数据库控制层接口
* @author: HuLiang
* @date: 2018-09-12 10:59:18
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Mapper
public interface EmailTemplateMapper extends BaseMapper<EmailTemplate> {

}