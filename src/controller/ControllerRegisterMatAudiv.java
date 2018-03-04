/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.AudiVisulMaterial;
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
import view.ViewRegisterBook;

/**
 *
 * @author Leonardo
 */
public class  ControllerRegisterMatAudiv {
    
    /*Funcion para escribir los materiales*/
    public static boolean writeAux(AudiVisulMaterial material) {
        try {
            ArrayList<AudiVisulMaterial> listMaterial=  read();
            listMaterial.add(material);
            
            File f = new File("materialAudiovisual.obj");
            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream salida = new ObjectOutputStream(fos);
            for (int i = 0; i < listMaterial.size(); i++) {
                AudiVisulMaterial materialA= listMaterial.get(i);
                System.out.print(i);
                System.out.print("\n"+ materialA.getType());
                salida.writeObject(materialA);
            } 
            salida.close();
            return true;
           
//          JOptionPane.showMessageDialog(this,"The book was correctly registered");

        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }
/*Funcion para leer el archivo que contiene la informacion de los libros y devuelve un Array de libros*/
    public static ArrayList<AudiVisulMaterial> read() {
        ObjectInputStream archive = null;

        ArrayList<AudiVisulMaterial> listMaterial = new ArrayList<AudiVisulMaterial>();
        int cont = 0;
        try {
            File f = new File("materialAudiovisual.obj");
            FileInputStream fis = new FileInputStream(f);
            archive = new ObjectInputStream(fis);
            while (true) {
              AudiVisulMaterial materialA = null;
                try {
                    materialA= (AudiVisulMaterial) archive.readObject();
                    listMaterial.add(materialA);
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
        return listMaterial;

    }
}
