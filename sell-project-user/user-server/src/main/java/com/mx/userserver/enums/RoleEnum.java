package com.mx.userserver.enums;

/**
 * @author mx
 * @date 2019/5/22 2:55 PM
 */
public enum RoleEnum {

    SELLER(1, "卖家"),
    BUYER(2, "买家"),
    ;

    private Integer userType;
    private String typeName;

    RoleEnum(Integer userType, String typeName) {
        this.userType = userType;
        this.typeName = typeName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
