package com.cleverti.assesment.domain.dbo.note.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequestDTO {

    @JsonProperty("title")
    private String title;
    private String content;
    private LocalDateTime createDate;
    private Integer user;

}
