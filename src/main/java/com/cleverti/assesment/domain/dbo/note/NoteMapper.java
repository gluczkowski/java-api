package com.cleverti.assesment.domain.dbo.note;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cleverti.assesment.domain.dbo.note.dto.CreateNoteRequestDTO;
import com.cleverti.assesment.domain.dbo.note.dto.NoteDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NoteMapper {

    private final ModelMapper mapper;

    public Note toEntity(CreateNoteRequestDTO request) {        
        return mapper.map(request, Note.class);
    }

    public NoteDTO toDto(Note entity) {
        return mapper.map(entity, NoteDTO.class);
    }   

    public List<NoteDTO> entityToListDTO(List<Note> notes) {        
        return notes.stream().map(this::toDto).collect(Collectors.toList());
    }

}
