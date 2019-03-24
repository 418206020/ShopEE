package cn.shopee.beetl.tags.dict;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @package  cn.shopee.tags.utils
 * @title: 字典初始化接口
 * @description: 字典初始化
 * @author: HuLiang
 * @date: 2017/8/30 9:04
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public interface InitDictable {
    /**
     * 字典初始化
     * @return
     */
    public Map<String, List<Dict>> initDict();
}
