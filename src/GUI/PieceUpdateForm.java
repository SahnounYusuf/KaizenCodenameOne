/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.Piece;
import services.ServicePiece;

/**
 *
 * @author Toshiba
 */
public class PieceUpdateForm extends Form {

    public PieceUpdateForm(Resources res, Piece p) {

        ServicePiece us = new ServicePiece();
        this.setLayout(BoxLayout.y());

        TextField tfIdu = new TextField(p.getIdu());
        TextField tfNom = new TextField(p.getNom());
        TextField tfType = new TextField(p.getType());
        TextField tfDescription = new TextField(p.getDescription());
        TextField tfPrix = new TextField(p.getPrix());
        
        tfIdu.setHint("Idu");
        tfNom.setHint("Name");
        tfType.setHint("Type");
        tfDescription.setHint("Description");
        tfPrix.setHint("Price");
        
        Label lbNom = new Label("Name");
        Label lbDescription = new Label("Description ");
        Label lbType = new Label("Type");
        Label lbPrix = new Label("Price");
        
        tfIdu.setUIID("VeloTextField");
        tfNom.setUIID("VeloTextField");
        tfType.setUIID("VeloTextField");
        tfDescription.setUIID("VeloTextField");
        tfPrix.setUIID("VeloTextField");

        Button btnDelete = new Button("Delete");

        btnDelete.addActionListener(e -> {
            if (Dialog.show("Delete Piece", "do you want to delete this piese?", "Yes", "No")) {
                int result = us.deletePiece(p.getIdp());
                if (result == 200) {
                    Dialog.show("Success", "Piece deleted", "OK", null);
                } else {
                    Dialog.show("ERROR", "SERVER ERROR", "OK", null);
                }
            }
        });
        Button btnUpdate = new Button("Modifiy");

        btnUpdate.addActionListener(e -> {

            Piece v = new Piece();
            v.setIdp(p.getIdp());
           v.setIdu(p.getIdu());
            v.setType(tfType.getText());
            v.setNom(tfNom.getText());
            v.setDescription(tfDescription.getText());
            v.setPrix(tfPrix.getText());

            if (us.modifyPiece(v) == 200) {
                Dialog.show("Succees", "Piece modified", "OK", null);
            } else {
                Dialog.show("ERROR", "SERVER ERROR", "OK", null);
            }
        });
        Button btnBack = new Button("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new PieceDisplayForm(res).show();
            }
        });

 this.addAll( lbNom,tfNom,lbType, tfType,lbDescription, tfDescription,lbPrix, tfPrix, btnUpdate, btnDelete, btnBack);
    }

}
