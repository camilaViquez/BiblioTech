/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Leonardo
 */
//clase que indica la descripcion de los articulos
public class Description implements Serializable {
  private boolean disponibility;
  private int quantity;
  private String decription;

    public boolean isDisponibility() {
        return disponibility;
    }

    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
  
public void enterMaterial()  
{
    
}

public void borrowMaterial()
{
    
}


}
