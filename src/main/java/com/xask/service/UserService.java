package com.xask.service;
import com.xask.database.dto.UserDTO;
import com.xask.database.entity.User;
import com.xask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
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
}
