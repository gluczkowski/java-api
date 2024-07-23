package com.cleverti.assesment.domain.dbo.note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findAllByUserIdAndIsActiveTrue(Integer id);

}
