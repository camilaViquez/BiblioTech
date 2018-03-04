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
public class Book extends Description implements Serializable {
    private String code;
    private String title;
    private String author;
    private String type;

    public Book(String code, String title, String author, String type, String description) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.type = type;
        setDecription(description);
        setDisponibility(true);
        setQuantity(1);
    }

    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public String toString()
    {
      String   data;
      data="Title: "+title+"\n"+" Author: "+ author+ "\n"+" ISBN: "+ code+"\n"+"Description: "+ getDecription();
      return data;        
    }
    
}
