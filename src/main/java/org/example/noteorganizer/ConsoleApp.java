package org.example.noteorganizer;

import org.example.noteorganizer.entity.Note;
import org.example.noteorganizer.repository.InMemoryNoteRepository;
import org.example.noteorganizer.repository.InMemoryUserRepository;
import org.example.noteorganizer.repository.NoteRepository;
import org.example.noteorganizer.repository.UserRepository;
import org.example.noteorganizer.service.NoteService;
import org.example.noteorganizer.service.UserService;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserRepository userRepository = new InMemoryUserRepository();
        NoteRepository noteRepository = new InMemoryNoteRepository();

        UserService userService = new UserService(userRepository);
        NoteService noteService = new NoteService(noteRepository, userService);

        System.out.println("==== Note Organizer ====");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("Choose username: ");
                String username = scanner.nextLine();
                System.out.print("Choose password: ");
                String password = scanner.nextLine();
                try {
                    userService.register(username, password);
                    System.out.println("User registered. You can now login.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 2) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (userService.login(username, password)) {
                    System.out.println("Login successful. Welcome " + username);
                    break;
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                return;
            } else {
                System.out.println("Invalid option.");
            }
        }

        // After login, notes CRUD
        while (true) {
            System.out.println("\n1. Create Note");
            System.out.println("2. View Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Content: ");
                        String content = scanner.nextLine();
                        System.out.print("Tags: ");
                        String tags = scanner.nextLine();
                        noteService.createNote(title, content, tags);
                        System.out.println("Note created.");
                    }
                    case 2 -> {
                        List<Note> notes = noteService.getAllNotes();
                        if (notes.isEmpty()) {
                            System.out.println("No notes found.");
                        } else {
                            notes.forEach(note -> {
                                System.out.println("ID: " + note.getId());
                                System.out.println("Title: " + note.getTitle());
                                System.out.println("Content: " + note.getContent());
                                System.out.println("Tags: " + note.getTags());
                                System.out.println("----");
                            });
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter note ID to update: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("New Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("New Content: ");
                        String newContent = scanner.nextLine();
                        System.out.print("New Tags: ");
                        String newTags = scanner.nextLine();
                        noteService.updateNote(id, newTitle, newContent, newTags);
                        System.out.println("Note updated.");
                    }
                    case 4 -> {
                        System.out.print("Enter note ID to delete: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        noteService.deleteNote(id);
                        System.out.println("Note deleted.");
                    }
                    case 5 -> {
                        System.out.println("Logging out...");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
