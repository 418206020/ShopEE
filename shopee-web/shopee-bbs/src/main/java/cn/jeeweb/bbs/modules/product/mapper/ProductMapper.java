package cn.shopee.bbs.modules.product.mapper;

import cn.shopee.bbs.modules.product.entity.Product;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.product.mapper
 * @title: 产品管理数据库控制层接口
 * @description: 产品管理数据库控制层接口
 * @author: HuLiang
 * @date: 2018-09-19 10:41:56
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    
}