package com.cleverti.assesment.domain.dbo.users.dto;

import com.cleverti.assesment.domain.dbo.users.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    private Integer id;    
    private String login;        
    private UserRole role;
    
}
