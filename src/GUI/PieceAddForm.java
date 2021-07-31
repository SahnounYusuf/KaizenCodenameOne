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
import entities.Piece;
import entities.User;
import services.ServicePiece;
import services.UserService;
import utils.StaticVars;

/**
 *
 * @author Toshiba
 */
public class PieceAddForm extends SideMenuBaseForm {

    public PieceAddForm(Resources res) {
        super(new BorderLayout());
        this.setLayout(BoxLayout.y());
        
        UserService us = new UserService();
//        setUIID("SettingsForm");
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
                                                new Label(" Piece", "WelcomeWhite"),
                                                new Label("", "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        setupSideMenu(res);
        
        TextField tfIdu = new TextField();
        TextField tfNom = new TextField();
        TextField tfType = new TextField();
        TextField tfDescription = new TextField();
        TextField tfPrix = new TextField();
        tfIdu.setHint("Idu");
        tfNom.setHint("Name");
        tfType.setHint("Type");
        tfDescription.setHint("Description");
        tfPrix.setHint("Price");
        
        tfIdu.setUIID("VeloTextField");
        tfNom.setUIID("VeloTextField");
        tfType.setUIID("VeloTextField");
        tfDescription.setUIID("VeloTextField");
        tfPrix.setUIID("VeloTextField");

        Button btnValider = new Button("Add piece");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tfNom.getText().length() < 3) {
                    Dialog.show("ERROR", "Name must be formed with 3 characters at least", "OK", null);
                } else if (tfType.getText().length() < 2) {
                    Dialog.show("ERROR", "Type must be formed with 2 characters at least", "OK", null);
                } else {

                    Piece v = new Piece();
                    v.setIdu(Integer.parseInt(tfIdu.getText()));
                    v.setType(tfType.getText());
                    v.setNom(tfNom.getText());
                    v.setDescription(tfDescription.getText());
                    v.setPrix(tfPrix.getText());
                    ServicePiece sp = new ServicePiece();
                    if (sp.addPiece(v) == 200) {
                        Dialog.show("SUCCESS", "Piece modified", "OK", null);
                    } else {
                        Dialog.show("ERROR", "SERVER ERROR", "OK", null);
                    }
                }
            }
        });
        Button btnAfficher = new Button("Show pieces");

        btnAfficher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                new PieceDisplayForm(res).show();
            }
        });

        this.addAll(tfIdu, tfNom, tfType, tfDescription, tfPrix, btnValider, btnAfficher);

    }

    @Override
    protected void showOtherForm(Resources res) {
    }

}
