package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import entities.User;
import services.UserService;
import utils.StaticVars;

/**
 *
 * @author Sahnoun Yusuf
 */
public class SettingsForm extends SideMenuBaseForm {

    public SettingsForm(Resources res) {

        super(new BorderLayout());
        UserService us = new UserService();
//        setUIID("SettingsForm");
        Toolbar tb = getToolbar();
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
                                                //                                                new Label("  " + u.getPrenom() + " ", "WelcomeBlue"),
                                                new Label("  " + u.getPrenom() + " ", "WelcomeWhite"),
                                                new Label(u.getNom(), "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);

        Label separator = new Label("", "BlueSeparatorLine");
        separator.setShowEvenIfBlank(true);
        add(BorderLayout.NORTH, separator);

        TextField tfFirst = new TextField(u.getNom(), "First Name");
        TextField tfLast = new TextField(u.getPrenom(), "Last Name");
        TextField tfEmail = new TextField(u.getEmail(), "Email", 20, TextField.EMAILADDR);
        TextField tfPhone = new TextField(String.valueOf(u.getPhone()), "Phone", 20, TextField.PHONENUMBER);
        TextField password = new TextField(u.getPassword(), "Password", 20, TextField.PASSWORD);

        Validator val = new Validator();
        val.addConstraint(tfFirst, new LengthConstraint(2));
        val.addConstraint(tfLast, new LengthConstraint(2));
        val.addConstraint(tfEmail, new LengthConstraint(3));
        val.addConstraint(tfPhone, new LengthConstraint(8));
        val.addConstraint(password, new LengthConstraint(6));

        tfFirst.getAllStyles().setMargin(LEFT, 0);
        tfLast.getAllStyles().setMargin(LEFT, 0);
        tfEmail.getAllStyles().setMargin(LEFT, 0);
        tfPhone.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);

        tfFirst.setUIID("SettingsTextField");
        tfLast.setUIID("SettingsTextField");
        tfEmail.setUIID("SettingsTextField");
        tfPhone.setUIID("SettingsTextField");
        password.setUIID("SettingsTextField");

        User user = new User();

//        Label loginIcon = new Label("", "TextField");
//        Label passwordIcon = new Label("", "TextField");
//        loginIcon.getAllStyles().setMargin(RIGHT, 0);
//        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
//        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
//        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        Button loginButton = new Button("Confirm");
        loginButton.setUIID("SettingsButton");
//        loginButton.getAllStyles().setMargin(LEFT, 0);
        loginButton.addActionListener(e -> {
            if (Dialog.show("Save Modifications", "Do you want to save the modifications you made?", "Yes", "No")) {
                user.setId(u.getId());
                user.setNom(tfLast.getText());
                user.setPrenom(tfFirst.getText());
                user.setEmail(tfEmail.getText());
                user.setPhone(Integer.valueOf(tfPhone.getText()));
                user.setPassword(tfEmail.getText());
                user.setRole(u.getRole());
                if (us.modifyUser(user) == 200) {
                    Dialog.show("Success", "You've changed your info", "Ok", null);;
                } else {
                    Dialog.show("Oops!", "Something went wrong", "Ok", null);
                }
            }
        });

        Button deleteButton = new Button("Delete your account");
        deleteButton.setUIID("DeleteButton");
        deleteButton.addActionListener(e -> {
            if (Dialog.show("Delete Account", "Do you really want to delete your account?", "Yes", "No")) {
                us.deleteUser(u.getId());
            }
        });

//        Label lb = new Label("Edit your information", "WelcomeBlue");
        Label spaceLabel;
        Label spaceLabel1 = new Label(" ");
        Label spaceLabel2 = new Label(" ");
        Label spaceLabel3 = new Label(" ");
        Label spaceLabel4 = new Label(" ");
        Label spaceLabel5 = new Label(" ");
        Label spaceLabel6 = new Label(" ");
        Label spaceLabel7 = new Label(" ");
        Label spaceLabel8 = new Label(" ");
        Label spaceLabel9 = new Label(" ");
        if (!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }

        Container infoUser = BoxLayout.encloseY(
                //BorderLayout.center(lb),
                spaceLabel,
                BorderLayout.center(tfFirst),
                spaceLabel1,
                BorderLayout.center(tfLast),
                spaceLabel2,
                BorderLayout.center(tfEmail),
                spaceLabel3,
                BorderLayout.center(tfPhone),
                spaceLabel4,
                BorderLayout.center(password),
                spaceLabel5,
                BorderLayout.center(loginButton),
                spaceLabel6,
                spaceLabel7,
                spaceLabel8,
                spaceLabel9,
                BorderLayout.center(deleteButton)
        );

        add(BorderLayout.CENTER, infoUser);

        setupSideMenu(res);
    }

    @Override
    protected void showOtherForm(Resources res) {
    }

}
