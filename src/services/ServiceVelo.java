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
import entities.Velo;
import utils.StaticVars;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceVelo {

    int result = 0;
    ArrayList<Velo> velos;

    public int addVelo(Velo p) {
        String url = StaticVars.baseURL + "/addVelo";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);

        req.addArgument("idu", p.getIdu());
        req.addArgument("brand", p.getBrand());
        req.addArgument("model", p.getModel());
        req.addArgument("type", p.getType());
        req.addArgument("size", p.getSize());
        req.addArgument("wheelsize", p.getWheelsize());
        req.addArgument("brakingtype", p.getBrakingtype());
        req.addArgument("numberofspeed", p.getNumberofspeed());
        req.addArgument("quantity", p.getQuantity());
        req.addArgument("color", p.getColor());
        req.addArgument("weight", p.getWeight());
        req.addArgument("price", p.getPrice());
        req.addArgument("description", p.getDescription());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;

    }

    public ArrayList<Velo> getVelos() {
        String url = StaticVars.baseURL + "/getVelos";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                velos = parseVelos(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return velos;
    }

    public ArrayList<Velo> parseVelos(String jsonText) {
        try {
            velos = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> velosListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) velosListJson.get("root");
            for (Map<String, Object> objet : list) {
                Velo p = new Velo();

                p.setIdu(objet.get("idu").toString());
                p.setBrand(objet.get("brand").toString());
                p.setModel(objet.get("model").toString());
                p.setType(objet.get("type").toString());
                p.setSize(objet.get("size").toString());
                p.setWheelsize(objet.get("wheelsize").toString());
                p.setBrakingtype(objet.get("brakingtype").toString());
                p.setNumberofspeed(objet.get("numberofspeed").toString());
                p.setQuantity(objet.get("quantity").toString());
                p.setColor(objet.get("color").toString());
                p.setWeight(objet.get("weight").toString());
                p.setPrice(objet.get("price").toString());
                p.setDescription(objet.get("description").toString());

                float id = Float.parseFloat(objet.get("id").toString());
                p.setId((int) id);

                velos.add(p);

            }

        } catch (IOException ex) {
        }
        return (velos);
    }

    // ========================= Delete Velo ========================
    public int deleteVelo(int id) {
        String url = StaticVars.baseURL + "/deleteVelo";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("id", String.valueOf(id));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    // ========================= Modify Velo ===========================
    public int modifyVelo(Velo p) {
        String url = StaticVars.baseURL + "/modifyVelo";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addArgument("idu", p.getIdu());
        req.addArgument("brand", p.getBrand());
        req.addArgument("model", p.getModel());
        req.addArgument("type", p.getType());
        req.addArgument("size", p.getSize());
        req.addArgument("wheelsize", p.getWheelsize());
        req.addArgument("brakingtype", p.getBrakingtype());
        req.addArgument("numberofspeed", p.getNumberofspeed());
        req.addArgument("quantity", p.getQuantity());
        req.addArgument("color", p.getColor());
        req.addArgument("weight", p.getWeight());
        req.addArgument("price", p.getPrice());
        req.addArgument("description", p.getDescription());
        req.addArgument("id", String.valueOf(p.getId()));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

}
