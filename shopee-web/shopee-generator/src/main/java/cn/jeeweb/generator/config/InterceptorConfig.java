package cn.shopee.generator.config;

import cn.shopee.common.interceptor.EncodingInterceptor;
import cn.shopee.generator.interceptor.LoginInterceptor;
import cn.shopee.generator.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.shopee.modules.config
 * @title:
 * @description: 拦截器
 * @author: HuLiang
 * @date: 2018/3/3 15:06
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

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
     * 编码拦截器
     * @return
     */
    //@Bean
    public LoginInterceptor loginInterceptor(){
        LoginInterceptor loginInterceptor=new LoginInterceptor();
        loginInterceptor.setLoginUrl("/admin/login");
        return loginInterceptor;
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
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //安全验证拦截器
        registry.addInterceptor(webInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        super.addInterceptors(registry);
    }
}
