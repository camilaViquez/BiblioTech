/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import controller.ControllerRegisterLoan;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
//clase para los prestamos
public class Loan implements Serializable {
    private boolean penalty;
    private int cost;
    private Date deliveryDate;
    private Date loanDate;
    private String codeArticle;
    private String name;
    private String ID;
    private String IdStudent;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

      public Loan(String codeArticle, String name, String IdStudent,Date date ) {
        this.codeArticle = codeArticle;
        this.name = name;
        this.IdStudent = IdStudent;
        this.loanDate=date;
      //  setID();
        setDeliveryDate(date);
        this.active=true;
        
    }
    
    
    public String getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(String IdStudent) {
        this.IdStudent = IdStudent;
    }

    public String getID() {
        return ID;
    }

    public void setID(int id) {
       
        this.ID = String.valueOf(id);//String.valueOf((int) (1000 * Math.random()) + 1);
    }

    

  
    
    public boolean isPenalty() {
        java.util.Date dateSystem = new Date();
        if (deliveryDate.before(dateSystem))
        {
           this.penalty=true;
        }else
        {
        this.penalty=false;
        }
        return penalty;
    }
    
    public String multa()
    {
        int dias =(int)((deliveryDate.getTime()-loanDate.getTime())/86400000);
        
        return "";
    }
    
    public void setPenalty(boolean penalty) {
        this.penalty = penalty;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
            Date dateD;
            dateD = ControllerRegisterLoan.addDaysDate(deliveryDate, 1);
        this.deliveryDate = dateD;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
    
   public String findMaterial()
   {
   
       
       return "";
   }
    
   public String showMaterial()
   {
       return "";
   }
   
 public boolean notifyDevolution ()  
 {
     return true;
 }
    
    
}
