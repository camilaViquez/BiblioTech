/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Leonardo
 */
public class Student extends Person {
    private String studentId;
   private String career;
   public boolean active ;

    public Student(String studentId,String name,String lastName, String career, String password) {
        System.out.print(name+studentId+lastName);
        this.studentId = studentId;
        this.career = career;
        setName(name);
        setLastName(lastName);
        active= true;
        setPassword(password);
        
    }

   

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
   public boolean isActive() {
        return active;
    }
   public void setActivo(boolean active) {
        this.active = active;
    }
   
  public int getTamaño() {
        return getName().length()*2 + 2 + 4 + 1;
    }
    
    
}
