package com.rain.service;

import com.rain.domain.Permission;
import com.rain.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    public List<Role> findAll();
}
