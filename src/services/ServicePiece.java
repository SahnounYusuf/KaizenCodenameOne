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
import entities.Piece;
import utils.StaticVars;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Toshiba
 */
public class ServicePiece {

    int result = 0;
    ArrayList<Piece> pieces;

    // add piece
    public int addPiece(Piece p) {
        String url = StaticVars.baseURL + "/addPiece";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);

        req.addArgument("idu", String.valueOf(p.getIdu()));
        req.addArgument("nom", p.getNom());
        req.addArgument("type", p.getType());
        req.addArgument("description", p.getDescription());
        req.addArgument("prix", p.getPrix());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    // get Piece
    
    public ArrayList<Piece> getPiece() {
        String url = StaticVars.baseURL + "/getPiece";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                pieces = parsePiece(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(pieces);
        return pieces;
    }

    public ArrayList<Piece> parsePiece(String jsonText) {
        try {
            pieces = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                Piece p = new Piece();
                p.setNom(objet.get("nom").toString());
                p.setDescription(objet.get("description").toString());
                p.setPrix(objet.get("prix").toString());
                p.setType(objet.get("type").toString());
                
                float idu = Float.parseFloat(objet.get("idu").toString());
                p.setIdu((int) idu);
             
                float idp = Float.parseFloat(objet.get("idp").toString());
                p.setIdp((int) idp);

                pieces.add(p);
            }
        } catch (IOException ex) {
        }
        return (pieces);
    }
//    public ArrayList<Piece> getPiece() {
//        pieces = new ArrayList<>();
//        String url = StaticVars.baseURL + "/getPiece";
//        ConnectionRequest req = new ConnectionRequest();
//        req.setUrl(url);
//        req.setPost(false);
//
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                pieces = parsePieces(new String(req.getResponseData()));
//            }
//        });
//        
//        System.out.println(pieces);
//
//        NetworkManager.getInstance().addToQueueAndWait(req);
//
//        return pieces;
//    }
//
//    public ArrayList<Piece> parsePieces(String jsonText) {
//        try {
//            pieces = new ArrayList<>();
//            JSONParser j = new JSONParser();
//            Map<String, Object> piecesListJson
//                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//
//            List<Map<String, Object>> list = (List<Map<String, Object>>) piecesListJson.get("root");
//            for (Map<String, Object> objet : list) {
//                Piece p = new Piece();
//                
//                float idp = Float.parseFloat(objet.get("idp").toString());
//                p.setIdp((int) idp);
//                
//                float idu = Float.parseFloat(objet.get("idu").toString());
//                p.setIdu((int) idu);
//                
//                p.setType(objet.get("type").toString()); 
//                p.setNom(objet.get("nom").toString());
//                p.setDescription(objet.get("description").toString());
//                p.setPrix(objet.get("prix").toString());
//
//                pieces.add(p);
//
//            }
//
//        } catch (IOException ex) {
//        }
//        return (pieces);
//    }

    //=======================Delete==============================
    public int deletePiece(int idp) {
        String url = StaticVars.baseURL + "/deletePiece";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("idp", String.valueOf(idp));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    // ========================= Modify  ===========================
    public int modifyPiece(Piece p) {
        String url = StaticVars.baseURL + "/modifyPiece";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addArgument("idu", String.valueOf(p.getIdu()));
        req.addArgument("type", p.getType());
        req.addArgument("nom", p.getNom());
        req.addArgument("description", p.getDescription());
        req.addArgument("prix", p.getPrix());
        req.addArgument("idp", String.valueOf(p.getIdp()));
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
