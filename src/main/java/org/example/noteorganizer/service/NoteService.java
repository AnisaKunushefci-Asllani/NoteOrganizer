package org.example.noteorganizer.service;

import org.example.noteorganizer.entity.Note;
import org.example.noteorganizer.entity.User;
import org.example.noteorganizer.repository.NoteRepository;

import java.util.List;

public class NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;

    public NoteService(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    public void createNote(String title, String content, String tags) {
        User user = userService.getLoggedInUser();
        if (user == null) throw new IllegalStateException("User not logged in");

        Note note = new Note(null, title, content, tags, user);
        noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        User user = userService.getLoggedInUser();
        if (user == null) throw new IllegalStateException("User not logged in");

        return noteRepository.findAllByUser(user);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public void updateNote(Long noteId, String newTitle, String newContent, String newTags) {
        Note note = noteRepository.findById(noteId);
        User user = userService.getLoggedInUser();

        if (note == null) throw new IllegalArgumentException("Note not found");
        if (!note.getUser().getUsername().equals(user.getUsername())) {
            throw new SecurityException("Cannot update another user's note");
        }

        note.setTitle(newTitle);
        note.setContent(newContent);
        note.setTags(newTags);

        noteRepository.save(note);  // save updates
    }

    public void deleteNote(Long noteId) {
        Note note = noteRepository.findById(noteId);
        User user = userService.getLoggedInUser();

        if (note == null) throw new IllegalArgumentException("Note not found");
        if (!note.getUser().getUsername().equals(user.getUsername())) {
            throw new SecurityException("Cannot delete another user's note");
        }

        noteRepository.delete(note);
    }
}
