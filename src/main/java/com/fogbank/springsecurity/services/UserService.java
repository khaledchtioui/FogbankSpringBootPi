package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  {


    public UserDetailsService userDetailsService();

    List<User> getAllUsers();

    public void removeUser(Long idUser);

    public User getUser(Long idUser);


}
