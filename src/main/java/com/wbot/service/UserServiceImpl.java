package com.wbot.service;

import java.util.List;

import com.wbot.models.AppUser;
import com.wbot.models.Role;
import com.wbot.repository.RoleRepo;
import com.wbot.repository.UserRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor 
@Transactional // database transaction
@Slf4j // for logging things
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("saving user {}", user.getUsername());
        return userRepo.save(user); // not handling duplicates
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {}", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to the user {}", roleName, username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        
    }

    @Override
    public AppUser getUser(String username) {
        log.info("fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("getting all users");
        return userRepo.findAll(); // do not do this in production, use pagination
    }

}