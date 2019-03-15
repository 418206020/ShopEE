package cn.shopee.common.mvc.exception;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.common.mvc.exception
 * @title:
 * @description: 验证错误
 * @author: HuLiang
 * @date: 2018/10/5 11:12
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public class ValidationException extends RuntimeException {


    public ValidationException() {
        super();
    }


    public ValidationException(String message) {
        super(message);
    }
}
