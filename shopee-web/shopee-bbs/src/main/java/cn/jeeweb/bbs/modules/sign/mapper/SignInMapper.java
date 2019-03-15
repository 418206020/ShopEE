package cn.shopee.bbs.modules.sign.mapper;

import cn.shopee.bbs.modules.sign.entity.SignIn;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.sign.mapper
 * @title: 签到数据库控制层接口
 * @description: 签到数据库控制层接口
 * @author: HuLiang
 * @date: 2018-09-05 16:03:35
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@Mapper
public interface SignInMapper extends BaseMapper<SignIn> {
   /**
    * 判断昨天是否签到
    * @return
    */
   Integer countYesterdaySign(@Param("userId") String userId);
  /**
   * 判断今天是否签到
   * @return
   */
   Integer countToDaySign(@Param("userId") String userId);

   List<SignIn> selectToDaySignList(Pagination page);

   List<SignIn> selectLatestSignList(Pagination page);
}