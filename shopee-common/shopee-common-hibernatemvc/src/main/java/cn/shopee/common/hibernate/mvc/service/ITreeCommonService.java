package cn.shopee.common.hibernate.mvc.service;

import cn.shopee.common.mvc.entity.tree.TreeNode;

import java.io.Serializable;

public interface ITreeCommonService<T extends Serializable & TreeNode<ID>, ID extends Serializable>
		extends ICommonService<T> {

}