package cn.shopee.common.sms.test;

import cn.shopee.common.sms.client.ISmsClient;
import cn.shopee.common.sms.client.TencentSmsClient;
import cn.shopee.common.sms.config.TencentConfigProperties;
import cn.shopee.common.sms.data.SmsResult;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.common.sms
 * @title:
 * @description: Cache工具类
 * @author: HuLiang
 * @date: 2018/9/11 14:59
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public class TestSmsMain {
    public static void main(String[] args) {
        //ISmsClient smsClient = new AliyunSmsClient();
        //ISmsClient smsClient = new HuyiSmsClient();
        // String templateContent = "您的验证码是：${code}。请不要把验证码泄露给其他人。";
        // SmsResult smsResult=smsClient.send("15085980308", templateContent,datas);
        ISmsClient smsClient = new TencentSmsClient();
        smsClient.init(TencentConfigProperties.buildConfigProperties());
        Map<String,Object> datas = new HashMap<>();
        datas.put("1",654789);
        datas.put("2",654789);
        // String templateContent = "您的验证码是：${code}。请不要把验证码泄露给其他人。";
        SmsResult smsResult=smsClient.send("15085980308", "191479",datas);
        System.out.println(JSONObject.toJSONString(smsResult));
    }
}
