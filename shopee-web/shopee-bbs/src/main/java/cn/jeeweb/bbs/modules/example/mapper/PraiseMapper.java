package cn.shopee.bbs.modules.example.mapper;

import cn.shopee.bbs.modules.example.entity.Praise;
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
 * @package cn.shopee.bbs.modules.example.mapper
 * @title: 点赞数据库控制层接口
 * @description: 点赞数据库控制层接口
 * @author: HuLiang
 * @date: 2018-09-04 16:46:49
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@Mapper
public interface PraiseMapper extends BaseMapper<Praise> {
 List<Praise> selectPraiseList(@Param("exampleId") String exampleId);

}