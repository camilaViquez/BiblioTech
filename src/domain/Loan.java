/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Loan {
    private boolean penalty;
    private int cost;
    private Date deliveryDate;
    private Date loanDate;
    private Book book;
    private AudiVisulMaterial MatAud;

    

    public Loan(Book book) {
        this.book = book;
        
    }

    public Loan(AudiVisulMaterial MatAud) {
        this.MatAud = MatAud;
        
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AudiVisulMaterial getMatAud() {
        return MatAud;
    }

    public void setMatAud(AudiVisulMaterial MatAud) {
        this.MatAud = MatAud;
    }
    
    public boolean isPenalty() {
        return penalty;
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
        this.deliveryDate = deliveryDate;
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
