package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import entities.User;
import services.UserService;
import utils.StaticVars;

/**
 *
 * @author Sahnoun Yusuf
 */
public class SettingsFormAdmin extends SideMenuBaseForm {

    public SettingsFormAdmin(Resources res) {

        super(new BorderLayout());
        setUIID("SettingsForm");
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
                                                new Label("  " + u.getPrenom() + " ", "WelcomeWhite"),
                                                //                                                new Label("  " + u.getPrenom() + " ", "WelcomeBlue"),
                                                new Label(u.getNom(), "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);

        Label separator = new Label("", "BlueSeparatorLine");
        separator.setShowEvenIfBlank(true);
        add(BorderLayout.NORTH, separator);

        TextField tfSearch = new TextField("", "Search");
        tfSearch.setUIID("SettingsSearch");
        tfSearch.getStyle().setBgTransparency(0);
//        tfSearch.addDataChangedListener(d);

        Label spaceLabel1 = new Label(" ");
        Container infoUser = BoxLayout.encloseY();
        infoUser.add(spaceLabel1);

//        infoUser.getStyle().setBgColor(0x66ff);
//        infoUser.getStyle().setBgTransparency(30);
        for (User p : new UserService().getUsers()) {
//            BorderLayout.center(tfFirst);
            infoUser.add(getPersonViewer(res, p));
        }
        infoUser.setScrollableY(true);
        infoUser.setScrollVisible(false);

        add(BorderLayout.CENTER, infoUser);
        add(BorderLayout.NORTH, tfSearch);
        setupSideMenu(res);
    }

    @Override
    protected void showOtherForm(Resources res) {

    }

    public Container getPersonViewer(Resources res, User p) {

        Label emailIcon = new Label("", "UserTextField");
        Label phoneIcon = new Label("", "UserTextField");
        Label userIcon = new Label("", "UserTextField");
        Label roleIcon = new Label("", "UserTextField");

        emailIcon.getAllStyles().setMargin(RIGHT, 0);
        phoneIcon.getAllStyles().setMargin(RIGHT, 0);
        userIcon.getAllStyles().setMargin(RIGHT, 0);
        roleIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_EMAIL, 3);
        FontImage.setMaterialIcon(phoneIcon, FontImage.MATERIAL_PHONE, 3);
        FontImage.setMaterialIcon(userIcon, FontImage.MATERIAL_PERSON, 3);
        FontImage.setMaterialIcon(roleIcon, FontImage.MATERIAL_COFFEE, 3);

        Label lbNom = new Label(p.getNom());
        Label lbPrenom = new Label(p.getPrenom());
        Container cntName = BoxLayout.encloseX(lbNom, lbPrenom);
        Label lbEmail = new Label(p.getEmail());
        Label lbPhone = new Label(String.valueOf(p.getPhone()));
        Label lbRole = new Label(p.getRole());

        lbNom.setUIID("UserTextField");
        lbPrenom.setUIID("UserTextField");
        lbEmail.setUIID("UserTextField");
        lbPhone.setUIID("UserTextField");
        lbRole.setUIID("UserTextField");

        Container cnt = BoxLayout.encloseY(
                BorderLayout.center(cntName).
                        add(BorderLayout.WEST, userIcon),
                BorderLayout.center(lbEmail).
                        add(BorderLayout.WEST, emailIcon),
                BorderLayout.center(lbPhone).
                        add(BorderLayout.WEST, phoneIcon),
                BorderLayout.center(lbRole).
                        add(BorderLayout.WEST, roleIcon)
        );

        cnt.getAllStyles().setMargin(LEFT, 2);

        Button btn = new Button();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ProfileForm(res, p).show();
            }
        });
        cnt.setLeadComponent(btn);
        cnt.getAllStyles().setBorder(Border.createInsetBorder(2));
        cnt.setUIID("SettingsContainer");
        cnt.getStyle().setBgColor(0xffffff);
        cnt.getStyle().setBgTransparency(0);
        cnt.setScrollableY(true);
        cnt.setScrollVisible(false);
        return cnt;
    }
}
