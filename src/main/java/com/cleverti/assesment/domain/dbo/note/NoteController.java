package com.cleverti.assesment.domain.dbo.note;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleverti.assesment.domain.dbo.note.dto.CreateNoteRequestDTO;
import com.cleverti.assesment.domain.dbo.note.dto.NoteDTO;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping()
    public ResponseEntity<Integer> createNote(@RequestBody CreateNoteRequestDTO createNoteRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(createNoteRequestDTO));
    }

    @GetMapping("/getAll/{userId}")
    public List<NoteDTO> getAllNotesByUserId(@PathVariable Integer userId){
        return noteService.getAllNotesByUserId(userId);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteANote(@PathVariable Integer noteId){
        noteService.deleteNote(noteId);
        return ResponseEntity.noContent().build();
    }
    
}
