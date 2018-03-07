/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ControllerDeliveryLoan;
import controller.ControllerRegisterLoan;
import domain.AudiVisulMaterial;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author camil
 */
public class LoanTest {
    
    public LoanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // public static Date addDaysDate(Date date, int days) {
     @Test
     public void loanTest() {
         //public static AudiVisulMaterial materialSelected(ArrayList<AudiVisulMaterial > listMaterial,String value)
         int cod=123;
         int num=5;
         String descrip = "TOSHIBA";
         String tipo = "PC";
         String color = "negra";
         String value = "123";
         AudiVisulMaterial material = new AudiVisulMaterial(cod,tipo,color,num, descrip);
         int cod2 = 562;
         int num2= 1;
         String descrip2 = "HP";
         String tipo2 = "PC";
         String color2 = "negra";
         String value2 = "456";
         AudiVisulMaterial material2 = new AudiVisulMaterial(cod2,tipo2,color2,num2, descrip2);
         ArrayList<AudiVisulMaterial > listMaterial =  new ArrayList<AudiVisulMaterial >();
         listMaterial.add(material);
         listMaterial.add(material2);
         ControllerRegisterLoan.materialSelected(listMaterial, value);
         
         Date date = new Date();
         int days = 2;
         ControllerRegisterLoan.addDaysDate(date, days);
         for(AudiVisulMaterial m: listMaterial){
             System.out.println(m.toString());
             
         }

     }
}
