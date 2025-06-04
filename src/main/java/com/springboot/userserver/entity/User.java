package com.springboot.userserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author
 * @since 2025-05-23
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    private  String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
