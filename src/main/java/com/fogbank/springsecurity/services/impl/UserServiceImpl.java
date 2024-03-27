package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository ;
    @Override
    public  UserDetailsService userDetailsService ()
    {
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)
                    {
                return userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
            }
        };
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Long idUser) {

        userRepository.deleteById(idUser);

    }

    @Override
    public User getUser(Long idUser) {
        return userRepository.findById(idUser).orElse(null);
    }


}
