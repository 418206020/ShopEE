package cn.shopee.generator.config;

import cn.shopee.common.query.resolver.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.shopee.config
 * @title:
 * @description:  HandlerMethodArgumentResolver
 * @author: HuLiang
 * @date: 2018/3/3 17:12
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
@Configuration
public class ResolverConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new QueryMethodArgumentResolver());
        argumentResolvers.add(new PageableMethodArgumentResolver());
        argumentResolvers.add(new FormModelMethodArgumentResolver());
        argumentResolvers.add(new RequestJsonParamMethodArgumentResolver());
        argumentResolvers.add(new PropertyPreFilterMethodArgumentResolver());
    }

}


