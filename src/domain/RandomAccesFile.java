/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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

    public static void createFileStudent(File archive) throws IOException {
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
        createFileStudent(archive); 
        Student[] listStudents = new Student[numRegisters];
        for(int i=0; i<numRegisters; ++i)
            listStudents[i] = getStudent(i);
        close(); 
        archive.delete(); 

        File tempo = new File("temporal.dat");
        createFileStudent(tempo); // Como no existe se crea el archivo.
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
    
      public static int searchEstudentRegister(String searched) throws IOException {
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
    
    
}
