package cn.shopee.entity;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package PACKAGE_NAME
 * @title:
 * @description: Cache工具类
 * @author: HuLiang
 * @date: 2018/5/23 11:33
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public class User implements Serializable {
    private String username;
    private Organization organization;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
