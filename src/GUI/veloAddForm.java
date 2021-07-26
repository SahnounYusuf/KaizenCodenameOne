/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entities.User;
import entities.Velo;
import services.ServiceVelo;
import services.UserService;
import utils.StaticVars;

/**
 *
 * @author bhk
 */
public class veloAddForm extends SideMenuBaseForm {

    public veloAddForm(Resources res) {
        super(new BorderLayout());
        this.setLayout(BoxLayout.y());

        UserService us = new UserService();
        Toolbar tb = this.getToolbar();
        tb.setTitleCentered(false);
        User u = StaticVars.getCurrentUser();
        Image profilePic = res.getImage("user-picture.jpg");
        Image tintedImage = Image.createImage(profilePic.getWidth(), profilePic.getHeight());
        Graphics g = tintedImage.getGraphics();
        g.drawImage(profilePic, 0, 0);
        g.drawImage(res.getImage("gradient-overlay.png"), 0, 0, profilePic.getWidth(), profilePic.getHeight());

        tb.getUnselectedStyle().setBgImage(tintedImage);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Button settingsButton = new Button("");
        settingsButton.setUIID("Title");
        FontImage.setMaterialIcon(settingsButton, FontImage.MATERIAL_SETTINGS);

        Label space = new Label("", "TitlePictureSpace");
        space.setShowEvenIfBlank(true);
        Container titleComponent
                = BorderLayout.north(
                        BorderLayout.west(menuButton).
                                add(BorderLayout.CENTER, space).
                                add(BorderLayout.SOUTH,
                                        FlowLayout.encloseIn(
                                                new Label(" Velo", "WelcomeWhite"),
                                                new Label("", "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);

        setupSideMenu(res);

        TextField tfidu = new TextField();
        TextField tfBrand = new TextField();
        TextField tfModel = new TextField();
        TextField tfType = new TextField();
        TextField tfSize = new TextField();
        TextField tfWheelsize = new TextField();
        TextField tfBrakingtype = new TextField();
        TextField tfNumberofspeed = new TextField();
        TextField tfQuantity = new TextField();
        TextField tfColor = new TextField();
        TextField tfWeight = new TextField();
        TextField tfPrice = new TextField();
        TextField tfDescription = new TextField();
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

        Button btnValider = new Button("Valider");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tfBrand.getText().length() < 3) {
                    Dialog.show("ERROR", "BRAND DOIT AVOIR AU MOINS 3 CARACTÈRES", "OK", null);
                } else if (tfModel.getText().length() < 5) {
                    Dialog.show("ERROR", "MODEL DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else if (tfType.getText().length() < 5) {
                    Dialog.show("ERROR", "TYPE DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else if (tfSize.getText().length() < 5) {
                    Dialog.show("ERROR", "SIZE DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else if (tfWheelsize.getText().length() < 5) {
                    Dialog.show("ERROR", "WHEELSIZE DOIT AVOIR AU MOINS 5 ENTIERS", "OK", null);
                } else if (tfBrakingtype.getText().length() < 5) {
                    Dialog.show("ERROR", "BRAKINGTYPE DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else if (tfNumberofspeed.getText().length() < 5) {
                    Dialog.show("ERROR", "NUMBEROFSPEED DOIT AVOIR AU MOINS 5 ENTIERS", "OK", null);
                } else if (tfQuantity.getText().length() < 0) {
                    Dialog.show("ERROR", "QUANTITY DOIT AVOIR AU MOINS 1 ENTIERS", "OK", null);
                } else if (tfColor.getText().length() < 5) {
                    Dialog.show("ERROR", "COLOR DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else if (tfWeight.getText().length() < 2) {
                    Dialog.show("ERROR", "WEIGHT DOIT AVOIR AU MOINS 2 ENTIERS", "OK", null);
                } else if (tfPrice.getText().length() < 2) {
                    Dialog.show("ERROR", "PRICE DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else if (tfDescription.getText().length() < 2) {
                    Dialog.show("ERROR", "DESCRIPTION DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else {

                    Velo v = new Velo(tfidu.getText(), tfBrand.getText(), tfModel.getText(), tfType.getText(), tfSize.getText(), tfWheelsize.getText(),
                            tfBrakingtype.getText(), tfNumberofspeed.getText(), tfQuantity.getText(), tfColor.getText(), tfWeight.getText(),
                            tfPrice.getText(), tfDescription.getText());
                    ServiceVelo sp = new ServiceVelo();
                    if (sp.addVelo(v) == 200) {
                        Dialog.show("SUCCESS", "Post added", "OK", null);
                    } else {
                        Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);
                    }
                }
            }
        });

        Button btnAfficher = new Button("Afficher");
        btnAfficher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new veloDisplayForm(res).show();
            }
        });

        this.addAll(tfidu, tfBrand, tfModel, tfType, tfSize, tfWheelsize, tfBrakingtype, tfNumberofspeed, tfQuantity, tfColor, tfWeight,
                tfPrice, tfDescription, btnValider, btnAfficher/*,btnUpdate*/);

    }

    @Override
    protected void showOtherForm(Resources res) {
    }

}
