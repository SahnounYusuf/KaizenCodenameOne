/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Event;
import utils.StaticVars;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yassine
 */
public class ServiceEvent {
    int result = 0;
    ArrayList<Event> events;
    

    public int addEvent(Event p) {
        String url = StaticVars.baseURL + "/addEvent";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
//        req.addArgument( "idu", p.getIdu());
        req.addArgument( "idu", "3");
        req.addArgument("event_name", p.getEvent_name());
        req.addArgument("date", p.getDate());
        req.addArgument("heure", p.getHeure());
        req.addArgument("place", p.getPlace());
       
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    
    public int updateEvent(Event p) {
        String url = StaticVars.baseURL + "/updateEvent";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
//        req.addArgument( "idu", p.getIdu());
        req.addArgument( "id", String.valueOf(p.getId()));
        req.addArgument("event_name", p.getEvent_name());
        req.addArgument("date", p.getDate());
        req.addArgument("heure", p.getHeure());
        req.addArgument("place", p.getPlace());
        
       
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    
    public int deleteEvent(Event p) {
        String url = StaticVars.baseURL + "/deleteEvent";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
//        req.addArgument( "idu", p.getIdu());
        req.addArgument( "id", String.valueOf(p.getId()));
              
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }
    
    
    
    

    public ArrayList<Event> getEvent() {
        String url = StaticVars.baseURL + "/getEvent";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt){
                events = parsePersons(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return events;
    }
    
    public ArrayList<Event> selectEvent(int id) {
        String url = StaticVars.baseURL + "/selectEvent2";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
//        req.addArgument( "idu", p.getIdu());
        req.addArgument( "id", String.valueOf(id));
        System.out.println(String.valueOf(id));
        System.out.println("0");

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt){
                events = parsePersons(new String(req.getResponseData()));
                 System.out.println("1");
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return events;
    }

    public ArrayList<Event> parsePersons(String jsonText) {
        try {
            events = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                                                
            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String,Object> objet : list){
                Event p = new Event();
                p.setEvent_name(objet.get("event_name").toString());
                p.setDate(objet.get("date").toString());
                p.setHeure(objet.get("heure").toString());
                p.setPlace(objet.get("place").toString());
                float id = Float.parseFloat(objet.get("id").toString());
                p.setId((int) id);
                float idu = Float.parseFloat(objet.get("idu").toString());
                p.setIdu((int) idu);
                
                events.add(p);
                
            }
            
            
        } catch (IOException ex) {
        }
        return (events);
    }
    
}
