/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noteapp;

/**
 *
 * @author aguso
 */

import java.util.List;
import java.util.Scanner;

public class NoteAppMenu {
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = getUserChoice();
            if (choice == 1) {
                addNote();
            } else if (choice == 2) {
                showNotes();
            } else if (choice == 3) {
                deleteNote();
            } else if (choice == 4) {
                exit = true;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    private void showMenu() {
        System.out.println("note app menu: Oleh Azzura Cut Wilhelmina NIM 12345678");
        System.out.println("1. ADD NOTES");
        System.out.println("2. SHOW NOTES");
        System.out.println("3. DELETE NOTES");
        System.out.println("4. EXIT");
        System.out.print("ENTER YOUR CHOICE (1-4): ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addNote() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Catatan: ");
        String note = scanner.nextLine();
        noteService.createNote(note);
        System.out.println("Catatan disimpan: " + note);
    }

    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println("Catatan tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    private void deleteNote() {
        showNotes();
        if (noteService.getNoteCount() > 0) {
            System.out.print("Pilih catatan yang akan dihapus: ");
            int noteIndex = getUserChoice() - 1;
            if (noteIndex >= 0 && noteIndex < noteService.getNoteCount()) {
                String note = noteService.getNoteByIndex(noteIndex);
                noteService.deleteNote(note);
                System.out.println("Catatan dihapus: " + note);
            } else {
                System.out.println("Catatan tidak valid.");
            }
        }
    }
}
