package com.coffeeshop.coffeeshopwebsite.services;

import com.coffeeshop.coffeeshopwebsite.models.Role;
import com.coffeeshop.coffeeshopwebsite.models.User;
import com.coffeeshop.coffeeshopwebsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Autowired
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }
    private List<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> foundUsers(String username) {
        return userRepository.findUsersByLogin(username);
    }

    public void saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            throw new IllegalArgumentException("User exists!");
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
}
