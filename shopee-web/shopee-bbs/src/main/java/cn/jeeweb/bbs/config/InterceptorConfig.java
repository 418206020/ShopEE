package cn.shopee.bbs.config;

import cn.shopee.bbs.interceptor.WebInterceptor;
import cn.shopee.common.interceptor.EncodingInterceptor;
import cn.shopee.common.security.shiro.interceptor.PermissionInterceptorAdapter;
import cn.shopee.bbs.common.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.web.modules.config
 * @title:
 * @description: 拦截器
 * @author: HuLiang
 * @date: 2018/3/3 15:06
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 编码拦截器
     * @return
     */
    //@Bean
    public HandlerInterceptor encodingInterceptor(){
        EncodingInterceptor encodingInterceptor=new EncodingInterceptor();
        return encodingInterceptor;
    }

    /**
     * 安全验证拦截器
     * @return
     */
    //@Bean
    public PermissionInterceptorAdapter permissionInterceptorAdapter(){
        PermissionInterceptorAdapter permissionInterceptorAdapter=new PermissionInterceptorAdapter();
        return permissionInterceptorAdapter;
    }

    /**
     * 日志拦截器
     * @return
     */
    //@Bean
    public LogInterceptor logInterceptor(){
        LogInterceptor logInterceptor=new LogInterceptor();
        logInterceptor.setOpenAccessLog(Boolean.TRUE);
        return logInterceptor;
    }

    /**
     * 编码拦截器
     * @return
     */
    //@Bean
    public WebInterceptor webInterceptor(){
        WebInterceptor webInterceptor=new WebInterceptor();
        return webInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //编码拦截器
        registry.addInterceptor(encodingInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //安全验证拦截器
        registry.addInterceptor(permissionInterceptorAdapter()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //日志拦截器
        registry.addInterceptor(logInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //web拦截器
        registry.addInterceptor(webInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");

    }
}
