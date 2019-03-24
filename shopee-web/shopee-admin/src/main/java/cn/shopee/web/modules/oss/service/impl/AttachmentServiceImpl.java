package cn.shopee.web.modules.oss.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.web.modules.oss.entity.Attachment;
import cn.shopee.web.modules.oss.mapper.AttachmentMapper;
import cn.shopee.web.modules.oss.service.IAttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.gov.gzst.oss.service.impl
* @title: 附件管理服务实现
* @description: 附件管理服务实现
* @author: HuLiang
* @date: 2018-04-25 14:25:54
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("attachmentService")
public class AttachmentServiceImpl  extends CommonServiceImpl<AttachmentMapper,Attachment> implements IAttachmentService {

}