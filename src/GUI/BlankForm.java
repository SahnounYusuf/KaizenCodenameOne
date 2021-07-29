/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entities.User;
import services.UserService;
import utils.StaticVars;

/**
 *
 * @author Sahnoun Yusuf
 */
public class BlankForm extends SideMenuBaseForm {

    public BlankForm(Resources res) {

        super(new BorderLayout());

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
                                                new Label("  Blank Form", "WelcomeWhite"),
                                                new Label("", "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        setupSideMenu(res);
    }

    @Override
    protected void showOtherForm(Resources res) {
    }
}
