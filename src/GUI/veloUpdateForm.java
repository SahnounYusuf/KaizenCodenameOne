/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.Velo;
import services.ServiceVelo;

/**
 *
 * @author Mechi
 */
public class veloUpdateForm extends Form {

    public veloUpdateForm(Resources res, Velo u) {

        this.setLayout(BoxLayout.y());
        ServiceVelo us = new ServiceVelo();
//        ComboBox Cid = new ComboBox();
        TextField tfidu = new TextField(u.getIdu());
        TextField tfBrand = new TextField(u.getBrand());
        TextField tfModel = new TextField(u.getModel());
        TextField tfType = new TextField(u.getType());
        TextField tfSize = new TextField(u.getSize());
        TextField tfWheelsize = new TextField(u.getWheelsize());
        TextField tfBrakingtype = new TextField(u.getBrakingtype());
        TextField tfNumberofspeed = new TextField(u.getNumberofspeed());
        TextField tfQuantity = new TextField(u.getQuantity());
        TextField tfColor = new TextField(u.getColor());
        TextField tfWeight = new TextField(u.getWeight());
        TextField tfPrice = new TextField(u.getPrice());
        TextField tfDescription = new TextField(u.getDescription());
        tfidu.setHint("Idu");
        tfBrand.setHint("Brand");
        tfModel.setHint("Model");
        tfType.setHint("Type");
        tfSize.setHint("Size");
        tfWheelsize.setHint("Wheelsize");
        tfBrakingtype.setHint("Brakingtype");
        tfNumberofspeed.setHint("Numberofspeed");
        tfQuantity.setHint("Quantity");
        tfColor.setHint("Color");
        tfWeight.setHint("Weight");
        tfPrice.setHint("Price");
        tfDescription.setHint("Description");

        tfidu.setUIID("VeloTextFiled");
        tfBrand.setUIID("VeloTextFiled");
        tfModel.setUIID("VeloTextFiled");
        tfType.setUIID("VeloTextFiled");
        tfSize.setUIID("VeloTextFiled");
        tfWheelsize.setUIID("VeloTextFiled");
        tfBrakingtype.setUIID("VeloTextFiled");
        tfNumberofspeed.setUIID("VeloTextFiled");
        tfQuantity.setUIID("VeloTextFiled");
        tfColor.setUIID("VeloTextFiled");
        tfWeight.setUIID("VeloTextFiled");
        tfPrice.setUIID("VeloTextFiled");
        tfDescription.setUIID("VeloTextFiled");
        Button btnDelete = new Button("Delete");

        btnDelete.addActionListener(e -> {
            if (Dialog.show("Delete Velo", "Do you really want to delete this Velo?", "Yes", "No")) {
                int result = us.deleteVelo(u.getId());
                if (result == 200) {
                    Dialog.show("Success", "Velo deleted", "OK", null);
                } else {
                    Dialog.show("ERROR", "Server error", "OK", null);
                }
            }

        });
        Button btnUpdate = new Button("Update");
        btnUpdate.addActionListener(e -> {
            Velo v = new Velo(u.getId(), tfidu.getText(), tfBrand.getText(), tfModel.getText(), tfType.getText(), tfSize.getText(), tfWheelsize.getText(),
                    tfBrakingtype.getText(), tfNumberofspeed.getText(), tfQuantity.getText(), tfColor.getText(), tfWeight.getText(),
                    tfPrice.getText(), tfDescription.getText());

            if (us.modifyVelo(v) == 200) {
                Dialog.show("Success", "Product modified", "OKAY", null);
            } else {
                Dialog.show("Failed", "Server Error", "OKAY", null);
            }
        });
        Button btnBack = new Button("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new veloAddForm(res).show();
            }
        });

        btnDelete.addActionListener(e -> {
            if (Dialog.show("Delete Velo", "Do you really want to delete this Velo?", "Yes", "No")) {
                int result = us.deleteVelo(u.getId());
                if (result == 200) {
                    Dialog.show("Success", "Velo deleted", "OK", null);
                } else {
                    Dialog.show("ERROR", "Server error", "OK", null);
                }
            }

        });

        this.addAll(tfidu, tfBrand, tfModel, tfType, tfSize, tfWheelsize, tfBrakingtype, tfNumberofspeed, tfQuantity, tfColor, tfWeight,
                tfPrice, tfDescription, btnUpdate, btnDelete, btnBack);

    }

}
