package com.duonghv.cm.crud.entities;

import com.duonghv.cm.crud.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    protected int id;
    protected Role role;
}