package com.wbot.service;

import java.util.List;

import com.wbot.models.AppUser;
import com.wbot.models.Role;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

}
