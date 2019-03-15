package cn.shopee.beetl.tags;

import org.beetl.core.BodyContent;
import org.beetl.core.GeneralVarTagBinding;
import org.beetl.core.exception.BeetlException;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.beetl.tags
 * @title:
 * @description: BodyTag
 * @author: HuLiang
 * @date: 2018/8/8 14:44
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public interface BodyTag {

    int EVAL_BODY_BUFFERED = 2;

    void setBodyContent(BodyContent bodyContent);

    void doInitBody() throws BeetlException;
}