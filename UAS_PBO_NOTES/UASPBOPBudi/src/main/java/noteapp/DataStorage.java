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

public interface DataStorage {
    void writeData(String note);

    List<String> readData();

    void deleteData(String note);
}
