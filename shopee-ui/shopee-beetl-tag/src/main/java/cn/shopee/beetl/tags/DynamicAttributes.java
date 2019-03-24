package cn.shopee.beetl.tags;

import cn.shopee.beetl.tags.exception.BeetlTagException;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.beetl.tags
 * @title:
 * @description: 动态数据整理
 * @author: HuLiang
 * @date: 2018/8/8 19:29
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public interface DynamicAttributes {
    void setDynamicAttribute(String localName, Object value) throws BeetlTagException;
}
