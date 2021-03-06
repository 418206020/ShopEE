package cn.shopee.generator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.generator
 * @title:
 * @description: 启动入口
 * @author: HuLiang
 * @date: 2018/8/14 10:25
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public class GeneratorBootServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GeneratorBootApplication.class);
    }
}