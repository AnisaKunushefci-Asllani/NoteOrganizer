package org.example.noteorganizer.repository;

import org.example.noteorganizer.entity.Note;
import org.example.noteorganizer.entity.User;

import java.util.List;

public interface NoteRepository {
    void save(Note note);
    List<Note> findAllByUser(User user);
    Note findById(Long id);
    void delete(Note note);
}
