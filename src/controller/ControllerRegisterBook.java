/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.ViewRegisterBook;

/**
 *
 * @author Leonardo
 */
public class ControllerRegisterBook {

    
 
    /*Funcion para escribir los libros*/
    public static boolean writeAux(Book book) {
        try {
            ArrayList<Book> listBook= read();
            listBook.add(book);
            
            File f = new File("book.obj");
            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream salida = new ObjectOutputStream(fos);
            for (int i = 0; i < listBook.size(); i++) {
                Book bookA= listBook.get(i);
                System.out.print(i);
                System.out.print("\n"+ bookA.getTitle());
                salida.writeObject(bookA);
            } 
            salida.close();
            return true;
           
//          JOptionPane.showMessageDialog(this,"The book was correctly registered");

        } catch (Exception e) {
            return false;
        }
    }
/*Funcion para leer el archivo que contiene la informacion de los libros y devuelve un Array de libros*/
    public static ArrayList<Book> read() {
        ObjectInputStream archive = null;

        ArrayList<Book> listBooks = new ArrayList<Book>();
        int cont = 0;
        try {
            File f = new File("book.obj");
            FileInputStream fis = new FileInputStream(f);
            archive = new ObjectInputStream(fis);
            while (true) {
                Book bookA = null;
                try {
                    bookA = (Book) archive.readObject();
                    listBooks.add(bookA);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewRegisterBook.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

        } catch (IOException io) {
            System.out.println("\n" + io);
        } finally {
            try {

                archive.close();
               // Book a = listBooks.get(2);
               //System.out.print(a.getAuthor());
            } catch (IOException ex) {
                Logger.getLogger(ViewRegisterBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listBooks;

    }

}
