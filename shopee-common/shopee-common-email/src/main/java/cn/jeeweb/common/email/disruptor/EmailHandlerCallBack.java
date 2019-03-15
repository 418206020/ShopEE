package cn.shopee.common.email.disruptor;


import cn.shopee.common.email.data.EmailResult;

public interface EmailHandlerCallBack {
    void onResult(EmailResult emailResult);
}