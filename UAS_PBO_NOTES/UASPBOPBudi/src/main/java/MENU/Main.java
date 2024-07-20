/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MENU;

import noteapp.NoteAppMenu;

/**
 *
 * @author aguso
 */
public class Main {
    public static void main(String[] args) {
        NoteAppMenu noteApp = new NoteAppMenu("notes.db");
        noteApp.start();
    }
}
