package cn.shopee.common.hibernate.mvc.parse;

import cn.shopee.common.query.data.Queryable;

/**
 * 动态拼 where、group by having
 * 
 * @author HuLiang
 *
 * @param <T>
 */
public interface QueryParse<T> {
	/**
	 * 解析查询条件
	 * 
	 * @param target
	 * @param queryable
	 */
	public void parseCondition(T target, Queryable queryable);

	/**
	 * 解析排序
	 * 
	 * @param target
	 * @param queryable
	 */
	public void parseSort(T target, Queryable queryable);

}
