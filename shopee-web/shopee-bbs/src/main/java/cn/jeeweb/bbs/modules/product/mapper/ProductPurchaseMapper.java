package cn.shopee.bbs.modules.product.mapper;

import cn.shopee.bbs.modules.product.entity.ProductOrder;
import cn.shopee.bbs.modules.product.entity.ProductPurchase;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.product.mapper
 * @title: 购买产品数据库控制层接口
 * @description: 购买产品数据库控制层接口
 * @author: HuLiang
 * @date: 2018-09-25 09:51:47
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@Mapper
public interface ProductPurchaseMapper extends BaseMapper<ProductPurchase> {
 /**
  *
  * @title: selectProductOrderList
  * @description: 查找主题列表
  * @param wrapper
  * @return
  * @return: List<User>
  */
 List<ProductPurchase> selectProductPurchaseList(Pagination page, @Param("ew") Wrapper<ProductPurchase> wrapper);

}