package com.cleverti.assesment.domain.dbo.note;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.cleverti.assesment.domain.dbo.note.dto.CreateNoteRequestDTO;
import com.cleverti.assesment.domain.dbo.note.dto.NoteDTO;
import com.cleverti.assesment.domain.dbo.users.User;
import com.cleverti.assesment.domain.dbo.users.UserService;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    private final UserService userService;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper, UserService userService) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
        this.userService = userService;
    }

    public Integer createNote(CreateNoteRequestDTO request) {
        request.setCreateDate(LocalDateTime.now());
        User user = userService.findById(request.getUser());

        var entity = noteMapper.toEntity(request);
        entity.setUser(user);
        return noteRepository.save(entity).getId();
    }

    public List<NoteDTO> getAllNotes() {
        return noteMapper.entityToListDTO(noteRepository.findAll());
    }

    public List<NoteDTO> getAllNotesByUserId(Integer id) {
        return noteMapper.entityToListDTO(noteRepository.findAllByUserIdAndIsActiveTrue(id));
    }

    public void deleteNote(Integer id) {
        // im using a logical delete here
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID (" + id + ") not found."));
        note.setActive(false);
        noteRepository.save(note);
    }
}
