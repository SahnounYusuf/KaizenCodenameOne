/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package entities;

/**
 *
 * @author muhamed
 */
public class post {
    private int idp ;
    private int idu ;
    private String description ;
    private int idl ;
    private int comments ;
    private String postedby ;

    public post(int idp, int idu, String description, int idl, int comments, String postedby) {
        this.idp = idp;
        this.idu = idu;
        this.description = description;
        this.idl = idl;
        this.comments = comments;
        this.postedby = postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public int getComments() {
        return comments;
    }

    public String getPostedby() {
        return postedby;
    }
    public int getIdp() {
        return idp;
    }

    public int getIdu() {
        return idu;
    }

    public String getDescription() {
        return description;
    }

    public int getIdl() {
        return idl;
    }

    public int getComment() {
        return comments;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdl(int idl) {
        this.idl = idl;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "post{" + "idp=" + idp + ", idu=" + idu + ", description=" + description + ", idl=" + idl + ", comment=" + comments + '}';
    }

    public post() {
    }

    public post(int idp, int idu, String description) {
        this.idp = idp;
        this.idu = idu;
        this.description = description;
    }

    public post(int idp, int idu) {
        this.idp = idp;
        this.idu = idu;
    }

    public post(int idp, int idu, String description, int Likes) {
        this.idp = idp;
        this.idu = idu;
        this.description = description;
        this.idl = idl;
    }

    public void setPhone(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


