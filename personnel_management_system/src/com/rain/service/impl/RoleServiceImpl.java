package com.rain.service.impl;

import com.rain.dao.RoleDao;
import com.rain.domain.Permission;
import com.rain.domain.Role;
import com.rain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
