package cn.shopee.web.modules.sys.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import cn.shopee.common.mybatis.mvc.entity.TreeEntity;

/**
 * @Title:
 * @Description:
 * @author HuLiang
 * @date 2017-02-07 21:06:09
 * @version V1.0
 *
 */
@TableName("sys_organization")
@SuppressWarnings("serial")
public class Organization extends TreeEntity<Organization> {
	@TableField(value = "create_by", fill = FieldFill.INSERT)
	protected String createBy; // 创建者
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	protected Date createDate; // 创建日期
	@TableField(value = "update_by", fill = FieldFill.UPDATE)
	protected String updateBy; // 更新者
	@TableField(value = "update_date", fill = FieldFill.UPDATE)
	protected Date updateDate; // 更新日期
	@TableField(value = "del_flag", fill = FieldFill.INSERT)
	protected String delFlag = "0"; // 删除标记（0：正常；1：删除 ）
	/** 备注 */
	@TableField(value = "remarks")
	private String remarks;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
