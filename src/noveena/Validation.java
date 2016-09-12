/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noveena;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sachindra
 */
public class Validation {
    
    
    
    
    public static boolean ValidName(String text){
        
        boolean valid=false;
        
        for (int i = 0; i < text.length(); i++) {  
            char ch = text.charAt(i);
            if (Character.isLetter(ch) || Character.isWhitespace(ch) || ch =='.' || ch == ' ') {                
                valid=true;                
            }
            else
                return false;            
        }
        if (valid) {
            return true;
        }    
        return false;        
    }
    
    public static boolean ValidNic(String nic){
        boolean NIC=false;
        if (nic.length()==10) {
            
              for (int i = 0; i < 9; i++) {
                  if (!Character.isDigit(nic.charAt(i))) {
                      NIC=false;
                      return false;
                  }
                  else {
                      NIC=true;
                  }                                    
            } 
              if (NIC=true) {
                  if ((nic.charAt(9)=='v') || (nic.charAt(9)=='V')) {                      
                      return true;   
                  }
                  else{
                      return false;                      
                  }                  
            }
        }
        else{
            return false;
        } 
        return false;
    }
    
    public static boolean ValidAddress(String text){
        
        boolean valid=false;
        
        for (int i = 0; i < text.length(); i++) {  
            char ch = text.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)|| Character.isWhitespace(ch) || ch ==',' || ch =='.' || ch =='/' || ch ==';' || ch ==':' || ch =='#' || ch =='\'') {                
                valid=true;                
            }
            else
                return false;            
        }
        if (valid) {
            return true;
        }    
        return false;        
    }   
    
    public static boolean ValidContactNo(String text){
     boolean valid =false;
     String[] AreaCodes = {"011", "021", "023", "024", "025", "026", "027", "031", "032", "033", "034", "035", "036", "037", "038", "041", "045", "047", "051", "052", "054", "055", "057", "063", "065", "066", "067", "081", "091"};
     String[] MobileCodes ={"070", "071", "072", "075", "076", "077", "078"};
             if (text.length()==10) {
                 for (int i = 0; i < 10; i++) {
                     char ch = text.charAt(i);
                     if (!Character.isDigit(ch)) {
                         return false;                 
                     }
                     else
                         valid = true;
                 }
             }
     if (valid) {
         
         for (String AreaCode : AreaCodes) {
             if (text.substring(0,3).equals(AreaCode)) {
                 if (text.charAt(3)=='2' || text.charAt(3)=='3' || text.charAt(3)=='4' ||text.charAt(3)=='5' || text.charAt(3)=='7' || text.charAt(3)=='9') {
                     return true;
                 }
  
             }
         }
         for (String MobileCode : MobileCodes) {
             if (text.substring(0,3).equals(MobileCode)) {
                return  true;
             }
         }
       
     }        
     return false;
 }
    
    public static boolean ValidFutureDate(String comDate){
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date= new Date();
        String CurrentDate = dateFormat.format(date);
        
        int difference = (comDate.compareTo(CurrentDate));
            
            if (difference<0) {
                return false;
            }
            else 
                return true;
    }   //Check whether if the date is in the future
    
    public static boolean ValidPastDate(String comDate){
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date= new Date();
        String CurrentDate = dateFormat.format(date);
        
        int difference = (CurrentDate.compareTo(comDate));
            
            if (difference>=0) {
                return true;
            }
            else 
                return false;
    }     //Check whether if the date is in the past or present
    
    public static boolean ValidDigits(String digit){
        boolean valid=false;
        for (int i = 0; i < digit.length(); i++) {
            char ch =digit.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
            else
                valid=true;
        }
        if (valid) {
            return true;
        }
        else
            return false;
    }
    
    public static boolean ValidTextAndDigits(String digit){
        boolean valid=false;
        for (int i = 0; i < digit.length(); i++) {
            char ch =digit.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                    valid =true;
            }
            else
                return false;
        }
        if (valid) {
            return true;
        }
        else
            return false;
    }
    
    public static boolean ValidTextOnly(String text){
        
        boolean valid=false;
        
        for (int i = 0; i < text.length(); i++) {  
            char ch = text.charAt(i);
            if (Character.isLetter(ch) || Character.isWhitespace(ch)) {                
                valid=true;                
            }
            else
                return false;            
        }
        if (valid) {
            return true;
        }    
        return false;        
    }
    
}
