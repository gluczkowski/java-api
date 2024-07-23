package com.cleverti.assesment.domain.dbo.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleverti.assesment.config.TokenService;
import com.cleverti.assesment.domain.dbo.users.dto.AuthenticationDTO;
import com.cleverti.assesment.domain.dbo.users.dto.LoginResponseDTO;
import com.cleverti.assesment.domain.dbo.users.dto.RegisterDTO;
import com.cleverti.assesment.domain.dbo.users.dto.UserDTO;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO authenticationDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.login(),
                authenticationDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        
        UserDTO userDTO = mapper.map(auth.getPrincipal(), UserDTO.class);
        

        return ResponseEntity.ok(new LoginResponseDTO(token, userDTO));

    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }
        
}
