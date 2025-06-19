package org.example.noteorganizer.repository;

import org.example.noteorganizer.entity.Note;
import org.example.noteorganizer.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryNoteRepository implements NoteRepository {

    private final Map<Long, Note> notes = new HashMap<>();
    private long idCounter = 1;

    @Override
    public void save(Note note) {
        if (note.getId() == null) {
            note.setId(idCounter++);
        }
        notes.put(note.getId(), note);
    }

    @Override
    public List<Note> findAllByUser(User user) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes.values()) {
            if (note.getUser().getUsername().equals(user.getUsername())) {
                result.add(note);
            }
        }
        return result;
    }

    @Override
    public Note findById(Long id) {
        return notes.get(id);
    }

    @Override
    public void delete(Note note) {
        notes.remove(note.getId());
    }
}
