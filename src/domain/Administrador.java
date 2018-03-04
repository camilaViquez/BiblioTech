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
public class Administrador extends Person {
    
    private int administradorId;
    private String password;
    public boolean active ;
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Administrador(int administradorId, String name, String lastName ,String password) {
        System.out.print(password);
        System.out.print(name+lastName);
        System.out.print(administradorId);
        this.administradorId = administradorId;
        this.password = password;
        this.active = true;
        setName(name);
        setLastName(lastName);
    }
    

    public int getAdministradorId() {
        return administradorId;
    }

    public void setAdministradorId(int administradorId) {
        this.administradorId = administradorId;
    }
    
     public boolean isActive() {
        return active;
    }
   public void setActive(boolean active) {
        this.active = active;
    }
    
      public int getTamaño() {
        return getName().length()*2 + 2 + 4 + 1;
    }
    
}
