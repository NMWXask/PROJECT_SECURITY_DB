package com.xask.service;
import com.xask.database.dto.UserDTO;
import com.xask.database.entity.User;
import com.xask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public User save(UserDTO dto){

        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();

        return userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user-> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                ))
                .orElseThrow(()->new UsernameNotFoundException("Failed to retrieve user :"+username));
    }
}
