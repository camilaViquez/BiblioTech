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
//not use
public class Configuration {
    private String password;
    private int numberDays;
    private int penaltyAmount;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    public int getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(int penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }
    
    
    
    
}
