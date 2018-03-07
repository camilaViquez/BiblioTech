/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Leonardo
 */
//clase para el material audio visual
public class AudiVisulMaterial extends Description {
    private int code;
    private String type;
    private String color;

    public AudiVisulMaterial(int code, String type, String color,int quantity, String description) {
        this.code = code;
        this.type = type;
        this.color = color;
        setDecription(description);
        setQuantity(quantity) ;
        
    }
    
    

    public int getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String toString()
    {
        String data;
        data = "Name: "+ type+ "\n"+"Code: " + code+ "\n"+"Description: "+ getDecription()+"\n"+"Quantity Available: "+ getQuantity();
        return data;
    }
}
