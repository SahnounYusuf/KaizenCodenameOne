/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.User;

/**
 *
 * @author bhk
 */
public class StaticVars {
    public static String baseURL="http://127.0.0.1:3001";
    public static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        StaticVars.currentUser = currentUser;
    }
    
    
}
