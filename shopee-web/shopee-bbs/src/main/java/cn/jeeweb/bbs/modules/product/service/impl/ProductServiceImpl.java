package cn.shopee.bbs.modules.product.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.product.service.IProductService;
import cn.shopee.bbs.modules.product.entity.Product;
import cn.shopee.bbs.modules.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.product.service.impl
* @title: 产品管理服务实现
* @description: 产品管理服务实现
* @author: HuLiang
* @date: 2018-09-19 10:41:56
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("productService")
public class ProductServiceImpl  extends CommonServiceImpl<ProductMapper,Product> implements  IProductService {

}