package cn.shopee.common.sms.disruptor;

import cn.shopee.common.sms.data.SmsResult;

import java.io.Serializable;

public interface SmsHandlerCallBack extends Serializable {
    void onResult(SmsResult smsResult);
}
