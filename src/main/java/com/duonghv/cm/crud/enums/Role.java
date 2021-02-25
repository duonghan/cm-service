package com.duonghv.cm.crud.enums;

public enum Role {
    ADMINISTRATOR, CLIENT;

    public String authority() {
        return this.name().toLowerCase();
    }
}
