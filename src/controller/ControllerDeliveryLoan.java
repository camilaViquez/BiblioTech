/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerRegisterLoan.read;
import domain.Loan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class ControllerDeliveryLoan {

    public static String informationLoan(String idStudent) {
        String aux = "";
        try {
            ArrayList<Loan> listLoans = ControllerRegisterLoan.read();
            int cont = 0;

            while (listLoans.size() > cont) {
                Loan loan = listLoans.get(cont);
                if (loan.getIdStudent().equals(idStudent) && loan.isActive()) {

                    aux += "Article: " + loan.getName() + "\n" + " Code of article" + loan.getCodeArticle() + "\n" + "Code of loan: " + loan.getID() + "\n" + "Delivery date: " + loan.getDeliveryDate() + "\n" +"---------------------------"+"\n" ;

                }else
                {
                    
                }
                cont++;
                System.out.print("\n" + cont + "cont");
            }
            return aux;
        } catch (Exception e) {
            return "" + e;
        }
    }

    public static Loan loanCorrect(String idLoan) {
        Loan loan = null;
        String aux = "";
        try {
            ArrayList<Loan> listLoans = ControllerRegisterLoan.read();
            int cont = 0;

            while (listLoans.size() > cont) {
                loan = listLoans.get(cont);
                if (loan.getID().equals(idLoan) && loan.isActive()) {

                    cont = listLoans.size();

                }
                cont++;
                System.out.print("\n" + cont + "cont");
            }
            return loan;

        } catch (Exception e) {
            return null;
        }
    }

    public static int fine() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String fine = "";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("configuration.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String line="";
            int cont = 0;

            while ((line = br.readLine()) != null) {
                System.out.println("entaaaaaaa");
                System.out.println("line: "+line);
                if (cont == 2) {
                    fine = line.trim();
                }
                cont++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int a=Integer.parseInt(fine);

        return a;
    }

    /*Funcion para volver a escribir los prestamos pero eliminando el que fue devuelto*/
    public static void writerNewLoan(String id) {

        try {
            ArrayList<Loan> listLoans = read();

            File f = new File("loans.obj");
            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream salida = new ObjectOutputStream(fos);
            for (int i = 0; i < listLoans.size(); i++) {

                Loan loanA = listLoans.get(i);
                if (loanA.getID().equals(id)) {

                } else {
                    System.out.print(loanA.getID());
                    System.out.print("\n" + i);
                    salida.writeObject(loanA);
                }
            }
            salida.close();

        } catch (Exception e) {

        }

    }

}
