package cn.shopee.web.modules.oss.helper;

import cn.shopee.common.oss.OSSUploadHelper;
import cn.shopee.common.oss.config.OssConfig;
import cn.shopee.common.oss.exception.FileNameLengthLimitExceededException;
import cn.shopee.common.oss.exception.InvalidExtensionException;
import cn.shopee.common.utils.IpUtils;
import cn.shopee.common.utils.StringUtils;
import cn.shopee.web.modules.oss.entity.Attachment;
import cn.shopee.web.modules.oss.service.IAttachmentService;
import cn.shopee.web.modules.sys.entity.User;
import cn.shopee.web.utils.JWTHelper;
import cn.shopee.web.utils.UserUtils;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.oss.controller
 * @title: 附件上传助手
 * @description: 附件上传助手
 * @author: HuLiang
 * @date: 2018-04-25 14:25:55
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@Component("attachmentHelper")
@EnableConfigurationProperties({OssConfig.class})
public class AttachmentHelper {

    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private OssConfig ossConfig;

    private OSSUploadHelper uploadHelper;

    @PostConstruct
    public void initHelper() {
        uploadHelper = new OSSUploadHelper();
        uploadHelper.init(ossConfig);
    }


    public Attachment upload(HttpServletRequest request, MultipartFile file) throws FileSizeLimitExceededException,
            IOException, FileNameLengthLimitExceededException, InvalidExtensionException {
        String basePath=request.getParameter("base_path");
        String url = uploadHelper.upload(request, file, basePath);
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        //file.getContentType();
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileExtension = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileExtension(fileExtension);
        attachment.setFileName(realFileName);
        attachment.setContentType(file.getContentType());
        attachment.setFilePath(url);
        attachment.setFileSize(size);
        attachment.setStatus("1");
        attachment.setUploadIp(IpUtils.getIpAddr(request));
        attachment.setUploadTime(new Date());
        attachment.setUserId(getUser(request).getId());
        attachment.setBasePath(basePath);
        attachmentService.insert(attachment);
        return attachment;
    }

    public Attachment remote(HttpServletRequest request,String remoteUrl) throws FileSizeLimitExceededException,
            IOException, FileNameLengthLimitExceededException, InvalidExtensionException {
        String basePath=request.getParameter("base_path");
        String url = uploadHelper.remote(request, remoteUrl, basePath);
        String filename =  remoteUrl.substring(remoteUrl.lastIndexOf('/')+1);
        URL remoteUri = new URL(remoteUrl);
        HttpURLConnection conn = (HttpURLConnection) remoteUri.openConnection();
        conn.setConnectTimeout(10 * 1000);
        long size = Integer.parseInt(conn.getHeaderField("Content-Length"));
        String contentType =  conn.getHeaderField("Content-Type");
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileExtension = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileExtension(fileExtension);
        attachment.setFileName(realFileName);
        attachment.setFilePath(url);
        attachment.setFileSize(size);
        attachment.setStatus("1");
        attachment.setUploadIp(IpUtils.getIpAddr(request));
        attachment.setUploadTime(new Date());
        attachment.setContentType(contentType);
        attachment.setUserId(getUser(request).getId());
        attachment.setBasePath(basePath);
        attachmentService.insert(attachment);
        return attachment;
    }

    private User getUser(HttpServletRequest request){
         HttpServletRequest  httpServletRequest=(HttpServletRequest)request;
        String token = httpServletRequest.getHeader("access_token");
        if (StringUtils.isEmpty(token)){
            token = httpServletRequest.getParameter("access_token");
        }
        if(!StringUtils.isEmpty(token)){
            String id= JWTHelper.getClaims(token,"id");
            String username=JWTHelper.getClaims(token,"username");
            String realname=JWTHelper.getClaims(token,"realname");
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setRealname(realname);
            return user;
        }
        return new User();
    }

}
