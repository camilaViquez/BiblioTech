/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrador;
import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Leonardo
 */
public class RandomAccesFile {
    private static RandomAccessFile flow;
    private static int numRegisters;
    private static int sizeRegisters= 80;

    public static void createFile(File archive) throws IOException {
        if (archive.exists() && !archive.isFile()) {
            throw new IOException(archive.getName() + "Don't a is  archive");
        }
        flow = new RandomAccessFile(archive, "rw");
        numRegisters = (int) Math.ceil(
                (double) flow.length() / (double) sizeRegisters);
    }

    public static void close() throws IOException {
        flow.close();
    }
/*Funcion para escribir en los archivos la lista de estudiantes*/
    public static boolean setStudent(int i, Student student) throws IOException {
        if(i >= 0 && i <= getNumRegisters()) {
            if(student.getTamaño() > sizeRegisters) {
                System.out.println("\nSize of registers exeeded");
            } else {
                flow.seek(i*sizeRegisters);
                flow.writeUTF(student.getStudentId());
                flow.writeUTF(student.getName());
                flow.writeUTF(student.getLastName());
                flow.writeUTF(student.getCareer());
                flow.writeUTF(student.getPassword());
                flow.writeBoolean(student.isActive());
                return true;
            }
        } else {
            System.out.println("\nSize of registers exeeded");
        }
        return false;
    }
/*Funcion para buscar si el registro en el que se encuentra guardada la informacion del estudiante se encuentra activo*/
    private static int searchRegisterActive() throws IOException {
 
        for(int i=0; i<getNumRegisters(); i++) 
        {
            flow.seek(i * sizeRegisters);
            if(!getStudent(i).isActive()) 
                return i;
        }
        return -1;        
    }
    
    
    /*Funcion para eliminar un estudiante*/
    public static boolean deleteStudent(String aEliminar) throws IOException {
        int pos = searchRegister(aEliminar);
        if(pos == -1) return false;
        Student deleteStudent = getStudent(pos);
        deleteStudent.setActivo(false);
        setStudent(pos, deleteStudent);
        return true;
    }
    /*Cambiar nombre a la funcion a ingles*/
    public static void compactarArchivo(File archive) throws IOException {
        createFile(archive); 
        Student[] listStudents = new Student[numRegisters];
        for(int i=0; i<numRegisters; ++i)
            listStudents[i] = getStudent(i);
        close(); 
        archive.delete(); 

        File tempo = new File("temporal.dat");
        createFile(tempo); // Como no existe se crea el archivo.
        for(Student student : listStudents)
            if(student.isActive())
                addStudent(student);
        close();
        
        tempo.renameTo(archive); //Cerramos el archivo
    }
    
    public static void addStudent(Student student) throws IOException {
        int inactive = searchRegisterActive();
        if(setStudent(inactive ==-1?numRegisters:inactive, student)) 
            numRegisters++;        
    }

    public static int getNumRegisters() {
        return numRegisters;
    }

    public static Student getStudent(int i) throws IOException {
        if(i >= 0 && i <= getNumRegisters()) {
            flow.seek(i * sizeRegisters);
            return new Student(flow.readUTF(),  flow.readUTF(),flow.readUTF(),flow.readUTF(),flow.readUTF());
            
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
            return null;
        }
    }

    public static int searchRegister(String searched) throws IOException {
        Student student;
        if (searched == null) {
            return -1;
        }
        for(int i=0; i<getNumRegisters(); i++) {
            flow.seek(i * sizeRegisters);
            student = getStudent(i);
            if(student.getName().equals(searched) && student.isActive()) {
                return i;
            }
        }
        return -1;
    }
    
      public static int searchEstudentRegister(String searched, String password) throws IOException {
        Student student;
        if (searched == null) {
            return -1;
        }
        for(int i=0; i<getNumRegisters(); i++) {
            flow.seek(i * sizeRegisters);
            student = getStudent(i);
            System.out.print(student.getPassword()+" ......  "+ student.getName());
            if(student.getStudentId().equals(searched) && student.isActive() && student.getPassword().equals(password) ) {
                return i;
            }
        }
        return -1;
    }
    
      
      
     public static void addAdministrator(Administrador admi) throws IOException {
        int inactive = searchRegisterActiveAdmi();
        if(setAdministrator(inactive ==-1?numRegisters:inactive, admi)) 
            numRegisters++;        
    }
     
    /*Funcion para escribir los administradores*/ 
     public static boolean setAdministrator(int i, Administrador admi ) throws IOException {
        if(i >= 0 && i <= getNumRegisters()) {
            if(admi.getTamaño() > sizeRegisters) {
                System.out.println("\nSize of registers exeeded");
            } else {
                flow.seek(i*sizeRegisters);
                flow.writeInt(admi.getAdministradorId());
                flow.writeUTF(admi.getName());
                flow.writeUTF(admi.getLastName());
                flow.writeUTF(admi.getPassword());
                flow.writeBoolean(admi.isActive());
                return true;
            }
        } else {
            System.out.println("\nSize of registers exeeded");
        }
        return false;
    }

/*Funcion para buscar si el registro en el que se encuentra guardada la informacion del administrador se encuentra activo*/
    private static int searchRegisterActiveAdmi() throws IOException {
 
        for(int i=0; i<getNumRegisters(); i++) 
        {
            flow.seek(i * sizeRegisters);
            if(!getAdministrator(i).isActive()) 
                return i;
        }
        return -1;        
    }
    

 public static Administrador getAdministrator(int i) throws IOException {
        if(i >= 0 && i <= getNumRegisters()) {
            flow.seek(i * sizeRegisters);
            return new Administrador(flow.readInt(),  flow.readUTF(),flow.readUTF(),flow.readUTF());
            
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
            return null;
        }
    }


    public static int searchAdmiRegister(String searched,String password) throws IOException {
        Administrador admi;
        if (searched == null) {
            return -1;
        }
        for(int i=0; i<getNumRegisters(); i++) {
            flow.seek(i * sizeRegisters);
            admi = getAdministrator(i);
            System.out.print(admi.getName().equals(searched) );
            System.out.print(admi.isActive());
            System.out.print(admi.getPassword().equals(password));
            System.out.print(admi.getPassword());
            System.out.print(password);
            if(admi.getName().equals(searched) && admi.isActive() && admi.getPassword().equals(password) ) {
                return i;
            }
        }
        return -1;
    }


}
