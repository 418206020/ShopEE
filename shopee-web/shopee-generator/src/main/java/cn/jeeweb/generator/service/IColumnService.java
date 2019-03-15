package cn.shopee.generator.service;

import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.generator.entity.Column;
import java.util.List;

public interface IColumnService extends ICommonService<Column> {
	/**
	 * 通过表ID获得所有的列
	 * @param tableId
	 * @return
	 */
	List<Column> selectListByTableId(String tableId);

}
