package cn.shopee.web.modules.sys.service;

import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.web.modules.sys.entity.RoleMenu;

/**   
 * @Title: 
 * @Description: 
 * @author shopee
 * @date 2017-02-21 12:54:43
 * @version V1.0   
 *
 */
public interface IRoleMenuService extends ICommonService<RoleMenu>  {

    void insert(String roleId, String menuId);

    void setMenu(String roleId,String menuIds);
}

