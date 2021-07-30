/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author muhamed
 */
public class comments {
    private int idp ;
    private int idu ;
    private String comment ;

    public comments(int idu, String comment) {
        this.idu = idu;
        this.comment = comment;
    }
    private int idc ; 

    public comments(int idp, int idu, String comment, int idc) {
        this.idp = idp;
        this.idu = idu;
        this.comment = comment;
        this.idc = idc;
    }

    public comments(int idp, int idu, String comment) {
        this.idp = idp;
        this.idu = idu;
        this.comment = comment;
    }

    public int getIdp() {
        return idp;
    }

    public int getIdu() {
        return idu;
    }

    public String getComment() {
        return comment;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public comments() {
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    @Override
    public String toString() {
        return "comment{" + "idp=" + idp + ", idu=" + idu + ", comment=" + comment + ", idc=" + idc + '}';
    }
    
    
}
