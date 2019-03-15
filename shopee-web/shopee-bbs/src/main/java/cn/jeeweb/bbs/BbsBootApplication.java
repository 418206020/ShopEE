package cn.shopee.bbs;

import com.spring4all.swagger.EnableSwagger2Doc;
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
@EnableSwagger2Doc
@ComponentScan({"cn.shopee.common.quartz.config","cn.shopee.common.oss","cn.shopee.common.sms","cn.shopee.ui.tags","cn.shopee.ui","cn.shopee.beetl.tags","cn.shopee.bbs"})
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class BbsBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BbsBootApplication.class, args);
    }
}