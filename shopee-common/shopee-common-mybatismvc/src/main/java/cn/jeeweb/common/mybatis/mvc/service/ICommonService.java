package cn.shopee.common.mybatis.mvc.service;

import cn.shopee.common.http.DuplicateValid;
import cn.shopee.common.query.data.Page;
import cn.shopee.common.query.data.Queryable;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface ICommonService<T> extends IService<T> {

     Page<T> list(Queryable queryable);

     Page<T> list(Queryable queryable, Wrapper<T> wrapper);

     List<T> listWithNoPage(Queryable queryable);

     List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper);

     Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper);
}