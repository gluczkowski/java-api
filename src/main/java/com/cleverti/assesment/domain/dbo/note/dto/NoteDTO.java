package com.cleverti.assesment.domain.dbo.note.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO { 
    Integer id;
    String title;
    String content;
    LocalDateTime createDate;
    private Integer userId;
    private boolean isActive;
    //Category category,
    //Status status 
}
