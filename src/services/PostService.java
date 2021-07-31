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
import entities.comments;
import entities.post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.StaticVars;
import services.UserService;

/**
 *
 * @author muhamed
 */
public class PostService {

    int result = 0;
    ArrayList<post> post;
    ArrayList<comments> comment;

    ArrayList<String> description;
    boolean flag = false;

    public int addpost(post p) {
        String url = StaticVars.baseURL + "/addpost";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("idp", String.valueOf(p.getIdp()));
        req.addArgument("idu", String.valueOf(StaticVars.currentUser));
        req.addArgument("description", p.getDescription());
        req.addArgument("idl", String.valueOf(p.getIdl()));
        req.addArgument("comments", String.valueOf(p.getComment()));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;

    }

    public int addcmt(comments c) {
        String url = StaticVars.baseURL + "/addcmt";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("idc", String.valueOf(c.getIdc()));
        req.addArgument("idu", String.valueOf(StaticVars.currentUser.getId()));
        req.addArgument("comment", c.getComment());
        req.addArgument("idp", String.valueOf(c.getIdp()));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;

    }

    public ArrayList<post> getpost() {
        String url = StaticVars.baseURL + "/getpost";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                post = parsepost(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(post);
        return post;
    }

    public ArrayList<post> parsepost(String jsonText) {
        try {
            post = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> postListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) postListJson.get("root");
            for (Map<String, Object> objet : list) {
                post p = new post();
                p.setDescription(objet.get("description").toString());
                p.setPostedby(objet.get("postedby").toString());
//                if (objet.get("comments").toString().equals(null)) {
//                    p.setComments(0);
//                } else {
//                    float comments = Float.parseFloat(objet.get("comments").toString());
//                    p.setComments((int) comments);
//                }

                float idl = Float.parseFloat(objet.get("idl").toString());
                p.setIdl((int) idl);

                float idp = Float.parseFloat(objet.get("idp").toString());
                p.setIdp((int) idp);

                post.add(p);
            }
        } catch (IOException ex) {
        }
        return (post);
    }

    public int deletepost(int idp) {
        String url = StaticVars.baseURL + "/deletepost";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("idp", String.valueOf(idp));
        req.addArgument("idu", String.valueOf(StaticVars.currentUser.getId()));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    public ArrayList<comments> getcomment(int idp) {
        String url = StaticVars.baseURL + "/getcomment";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("idp", String.valueOf(idp));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                comment = parsecomment(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(comment);
        return comment;
    }

    public ArrayList<comments> parsecomment(String jsonText) {
        try {
            comment = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> commentListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) commentListJson.get("root");
            for (Map<String, Object> objet : list) {
                comments ca = new comments();
                ca.setComment(objet.get("comment").toString());

                float idc = Float.parseFloat(objet.get("idc").toString());
                ca.setIdc((int) idc);
                float idu = Float.parseFloat(objet.get("idu").toString());
                ca.setIdu((int) idu);
                float idp = Float.parseFloat(objet.get("idp").toString());
                ca.setIdp((int) idp);

                comment.add(ca);
            }
        } catch (IOException ex) {
        }
        return (comment);
    }
}
