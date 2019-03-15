package cn.shopee.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.web
 * @title: Web启动入口
 * @description: Web启动入口
 * @author: HuLiang https://blog.csdn.net/u012943767/article/details/79360748
 * @date: 2018/5/22 14:56
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
@ComponentScan({"cn.shopee.ui.tags","cn.shopee.ui","cn.shopee.beetl.tags","cn.shopee.generator"})
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class GeneratorBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(GeneratorBootApplication.class, args);
    }
}

