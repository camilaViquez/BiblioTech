/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.AudiVisulMaterial;
import domain.Book;
import domain.Loan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ViewRegisterBook;

/**
 *
 * @author Leonardo
 */
public class ControllerRegisterLoan {
    /*Busqueda de libros por titulo*/
      public static boolean seekerBookName(String name, Book book) {
          String title = book.getTitle();
        if(name.isEmpty() || name.length()>title.length())
            return false;
        for(int i=0; i<name.length(); ++i)
            if( name.charAt(i) != title.charAt(i) )
                return false;
        return true;
    }
    /*Busqueda de libros por ISBN*/
    public static boolean seekerBookISBN(String name, Book book) {
          String code = book.getCode();
        if(name.isEmpty() || name.length()>code.length())
            return false;
        for(int i=0; i<name.length(); ++i)
            if( name.charAt(i) != code.charAt(i) )
                return false;
        return true;
    }
    
        /*Busqueda de material audiovisual por nombre*/
      public static boolean seekerMaterialName(String name, AudiVisulMaterial material) {
          String type = material.getType();
        if(name.isEmpty() || name.length()>type.length())
            return false;
        for(int i=0; i<name.length(); ++i)
            if( name.charAt(i) != type.charAt(i) )
                return false;
        return true;
    }
    
         /*Busqueda de material audiovisual por codigo*/
      public static boolean seekerMaterialCode(String searched, AudiVisulMaterial material) {
          String code = String.valueOf(material.getCode());
        if(searched.isEmpty() || searched.length()>code.length())
            return false;
        for(int i=0; i<searched.length(); ++i)
            if( searched.charAt(i) != code.charAt(i) )
                return false;
        return true;
    }
      
      public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
      }
    
      public static Book bookSelected(ArrayList<Book> listBook,String value)
      {
          int cont=0;
          int contA;
          while(cont<listBook.size())
          {
              contA=cont;
              System.out.print(listBook.get(cont).getTitle()+"=="+value);
              if(isNumeric(value))
              {
                  if(listBook.get(cont).getCode().equals(value))
                  {
                    cont=listBook.size();
                    System.out.print(cont);
                    return listBook.get(contA);
                  }
              }
              if(listBook.get(cont).getTitle().equals(value) )
              {
                  cont=listBook.size();
                  System.out.print(cont);
                  return listBook.get(contA);
              }
               cont++;
          }
          return null;
      } 
     public static AudiVisulMaterial materialSelected(ArrayList<AudiVisulMaterial > listMaterial,String value)
      {
          int cont=0;
          int contA;
          while(cont<listMaterial.size())
          {
              contA=cont;
              System.out.print(listMaterial.get(cont).getType()+"=="+value);
              if(isNumeric(value))
              {
                  if(listMaterial.get(cont).getCode()==Integer.valueOf(value)){
                     cont=listMaterial.size();
                  System.out.print(cont);
                  return listMaterial.get(contA); 
                  }
              }
              if(listMaterial.get(cont).getType().equals(value))
              {
                  cont=listMaterial.size();
                  System.out.print(cont);
                  return listMaterial.get(contA);
              }
               cont++;
          }
          return null;
      }    
     
     public static Date addDaysDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, days);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }
     
     
      /*Funcion para escribir los libros*/
    public static boolean write(Loan loan) {
        try {
            ArrayList<Loan> listLoans= read();
            listLoans.add(loan);
            
            File f = new File("loan.obj");
            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream salida = new ObjectOutputStream(fos);
            for (int i = 0; i < listLoans.size(); i++) {
                Loan loanA= listLoans.get(i);
                System.out.print(i);
                
                salida.writeObject(loanA);
            } 
            salida.close();
            return true;
           


        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }
/*Funcion para leer el archivo que contiene la informacion de los libros y devuelve un Array de libros*/
    public static ArrayList<Loan> read() {
        ObjectInputStream archive = null;

        ArrayList<Loan> listLoans = new ArrayList<Loan>();
        int cont = 0;
        try {
            File f = new File("loan.obj");
            FileInputStream fis = new FileInputStream(f);
            archive = new ObjectInputStream(fis);
            while (true) {
                Loan loanA = null;
                try {
                    
                    loanA = (Loan) archive.readObject();
                    listLoans.add(loanA);
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
        return listLoans;

    }

       
}
