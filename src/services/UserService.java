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
import entities.User;
import utils.StaticVars;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sahnoun Yusuf
 */
public class UserService {

    int result = 0;
    ArrayList<User> personnes;
    ArrayList<User> loggedUser;
    ArrayList<String> userPassword;
    ArrayList<String> passwords;
    boolean flag = false;

    public int addUser(User p) {
        String url = StaticVars.baseURL + "/addUser";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("id", String.valueOf(p.getId()));
        req.addArgument("nom", p.getNom());
        req.addArgument("prenom", p.getPrenom());
        req.addArgument("email", p.getEmail());
        req.addArgument("phone", String.valueOf(p.getPhone()));
        req.addArgument("password", p.getPassword());
        req.addArgument("role", "user");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    public ArrayList<User> getUsers() {
        String url = StaticVars.baseURL + "/getUsers";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                personnes = parsePersons(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(personnes);
        return personnes;
    }

    public ArrayList<User> parsePersons(String jsonText) {
        try {
            personnes = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                User p = new User();
                p.setNom(objet.get("nom").toString());
                p.setPrenom(objet.get("prenom").toString());
                p.setEmail(objet.get("email").toString());

                float phone = Float.parseFloat(objet.get("phone").toString());
                p.setPhone((int) phone);

                p.setPassword(objet.get("password").toString());
                p.setRole(objet.get("role").toString());
                float id = Float.parseFloat(objet.get("id").toString());
                p.setId((int) id);

                personnes.add(p);
            }
        } catch (IOException ex) {
        }
        return (personnes);
    }

    // ======================== Login Verification =====================================
    public ArrayList<User> verifyUser(String username, String password) {
        String url = StaticVars.baseURL + "/verifyUser";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("id", username);
        req.addArgument("password", password);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                loggedUser = parseLoginUser(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return loggedUser;
    }

    public ArrayList<User> parseLoginUser(String jsonText) {
        try {
            loggedUser = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                User p = new User();
                p.setNom(objet.get("nom").toString());
                p.setPrenom(objet.get("prenom").toString());
                p.setEmail(objet.get("email").toString());

                float phone = Float.parseFloat(objet.get("phone").toString());
                p.setPhone((int) phone);

                p.setPassword(objet.get("password").toString());
                p.setRole(objet.get("role").toString());
                float id = Float.parseFloat(objet.get("id").toString());
                p.setId((int) id);

                loggedUser.add(p);
            }
        } catch (IOException ex) {
        }
        return (loggedUser);
    }

    // =================== Role changing =====================================
    public int makeModerator(int id) {
        String url = StaticVars.baseURL + "/makeModerator";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("role", "Moderator");
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

    public int makeUser(int id) {
        String url = StaticVars.baseURL + "/makeUser";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("role", "user");
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

    // ========================= Delete User ========================
    public int deleteUser(int id) {
        String url = StaticVars.baseURL + "/deleteUser";
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

    // ========================= Modify User ===========================
    public int modifyUser(User u) {
        String url = StaticVars.baseURL + "/modifyUser";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("nom", u.getNom());
        req.addArgument("prenom", u.getPrenom());
        req.addArgument("email", u.getEmail());
        req.addArgument("phone", String.valueOf(u.getPhone()));
        req.addArgument("password", u.getPassword());
        req.addArgument("id", String.valueOf(u.getId()));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    // ==================== Retrieve password by email or phone ==================
    
    public ArrayList<String> retriveUserPasswordByEmail(String email) {
        String url = StaticVars.baseURL + "/getUserPasswordByEmail";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        
        req.addArgument("email", email);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                userPassword = parsePassword(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(personnes);
        return userPassword;
    }
    
        public ArrayList<String> parsePassword(String jsonText) {
        try {
            passwords = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                String pass = "";

                pass = objet.get("password").toString();

                passwords.add(pass);
            }
        } catch (IOException ex) {
        }
        return (passwords);
    }
    
    public ArrayList<String> retriveUserPasswordBySms(String phone) {
        String url = StaticVars.baseURL + "/getUserPasswordByPhone";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
        
        req.addArgument("phone", phone);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                userPassword = parsePhone(new String(req.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(personnes);
        return userPassword;
    }
    
        public ArrayList<String> parsePhone(String jsonText) {
        try {
            passwords = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                String pass = "";

                pass = objet.get("password").toString();

                passwords.add(pass);
            }
        } catch (IOException ex) {
        }
        return (passwords);
    }
}
