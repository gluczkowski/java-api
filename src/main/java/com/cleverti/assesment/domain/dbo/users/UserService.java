package com.cleverti.assesment.domain.dbo.users;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cleverti.assesment.domain.dbo.users.dto.RegisterDTO;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public ResponseEntity<Void> register(RegisterDTO registerDTO){        
        if(userRepository.findByLogin(registerDTO.login())  != null) return ResponseEntity.badRequest().build();

        String encriptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());        
        // im creating by default with role user.
        User newUser = new User(registerDTO.login(), encriptedPassword, UserRole.USER);

        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(() ->new NoSuchElementException("ID ("+id+") not found."));
    }
}
