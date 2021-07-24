/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;

/**
 *
 * @author Sahnoun Yusuf
 */
public class SmsService {

    public static final String ACCOUNT_SID = "ACb6048bcc447741b1155a12ae9e46d19d";
    public static final String AUTH_TOKEN = "e105d85b616647a5272a1899ead0f2b7";
    String pass = "";

    public SmsService() {
    }

    public void SendPassword(String userPhoneNumber){
        UserService us = new UserService();
        ArrayList<String> userPassword = us.retriveUserPasswordBySms(userPhoneNumber);
        for (String p: userPassword)
        {
            pass = p;
        }
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+216" + userPhoneNumber),
                new com.twilio.type.PhoneNumber("+14233972171"),
                "your password is: " + pass)
                .create();

        System.out.println(message.getSid());
    }

    public void SendVerificationCode(String userPhoneNumber, String code){

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+216" + userPhoneNumber),
                new com.twilio.type.PhoneNumber("+14233972171"),
                "your Verification Code: " + code)
                .create();

        System.out.println(message.getSid());
    }

}