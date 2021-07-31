/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.io.Log.p;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Event;
import entities.Participant;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.StaticVars;

/**
 *
 * @author Yassine
 */
public class ServiceParticipant {
    
    ArrayList<Participant> participants;
        User partic;

    int result = 0;
    
    
    
    public ArrayList<Participant> verifyParticipant(int ide,int idu) {
        String url = StaticVars.baseURL + "/verifyParticipant";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument( "ide", String.valueOf(ide));
        req.addArgument( "idu", String.valueOf(idu));
        System.out.println(String.valueOf(ide+" "+idu));
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt){
            participants = parseParticipant(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return participants;
    }
    
    
    public int addParticipant(Participant p) {
        String url = StaticVars.baseURL + "/addParticipant";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
//        req.addArgument( "idu", p.getIdu());
        req.addArgument( "ide", String.valueOf(p.getIde()));
        req.addArgument( "idu", String.valueOf(p.getIdu()));
        
       
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    
    public ArrayList<Participant> selectParticipant(int ide) {
        String url = StaticVars.baseURL + "/selectParticipant";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument( "ide", String.valueOf(ide));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt){
            participants = parseParticipant(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return participants;
    }
    
    
    public int deleteParticipant(Participant p) {
        String url = StaticVars.baseURL + "/deleteParticipant";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
//        req.addArgument( "idu", p.getIdu());
        req.addArgument( "ide", String.valueOf(p.getIde()));
        req.addArgument( "idu", String.valueOf(p.getIdu()));      
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    
    public int deleteEventParticipant(int ide) {
        String url = StaticVars.baseURL + "/deleteEventParticipant";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument( "ide", String.valueOf(ide));
              
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    
    public User getInfoParticipant(int id) {
        String url = StaticVars.baseURL + "/getParticipant";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument( "id", String.valueOf(id));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                partic = parsePersons(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        
        return partic;
    }
    
    
    
    
    
    
    
    
    public ArrayList<Participant> parseParticipant(String jsonText) {
        try {
            participants = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                                                
            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String,Object> objet : list){
                Participant p = new Participant();
                float ide = Float.parseFloat(objet.get("ide").toString());
                p.setIde((int) ide);
                float idu = Float.parseFloat(objet.get("idu").toString());
                p.setIdu((int) idu);
                
                participants.add(p);
                
            }
            
            
        } catch (IOException ex) {
        }
        return (participants);
    }
    
    public User parsePersons(String jsonText) {
        User p = new User();
        try {
            
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                p.setNom(objet.get("nom").toString());
                p.setPrenom(objet.get("prenom").toString());
                p.setEmail(objet.get("email").toString());

                float phone = Float.parseFloat(objet.get("phone").toString());
                p.setPhone((int) phone);

                p.setPassword(objet.get("password").toString());
                p.setRole(objet.get("role").toString());
                float id = Float.parseFloat(objet.get("id").toString());
                p.setId((int) id);

                
            }
        } catch (IOException ex) {
        }
        return (p);
    }
}
