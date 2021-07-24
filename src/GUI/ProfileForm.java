/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entities.User;
import services.UserService;
import utils.StaticVars;

/**
 * 
 * @author Sahnoun Yusuf
 */
public class ProfileForm extends SideMenuBaseForm {

    public ProfileForm(Resources res, User u) {
        super(BoxLayout.y());
        setUIID("SettingsForm");
        UserService us = new UserService();
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container remainingTasks = BoxLayout.encloseY(
                new Label("12", "CenterTitle"),
                new Label("Opened the app", "CenterSubTitle")
        );
        remainingTasks.setUIID("RemainingTasks");
        Container completedTasks = BoxLayout.encloseY(
                new Label("22/07/2021", "CenterTitle"),
                new Label("Last seen", "CenterSubTitle")
        );
        completedTasks.setUIID("CompletedTasks");

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label(u.getNom() + " " + u.getPrenom(), "Title"),
                                new Label(u.getRole(), "SubTitle")
                        )
                ).add(BorderLayout.WEST, profilePicLabel),
                GridLayout.encloseIn(2, remainingTasks, completedTasks)
        );

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));

//        add(new Label("Today", "TodayTitle"));
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

//        addButtonBottom(arrowDown, "Finish landing page concept", 0xd997f1, true);
//        addButtonBottom(arrowDown, "Design app illustrations", 0x5ae29d, false);
//        addButtonBottom(arrowDown, "Javascript training ", 0x4dc2ff, false);
//        addButtonBottom(arrowDown, "Surprise Party for Matt", 0xffc06f, false);
        Label lbCin = new Label(String.valueOf(u.getId()), "TodayTitle");
        Label lbFirst = new Label(u.getNom(), "TodayTitle");
        Label lbLast = new Label(u.getPrenom(), "TodayTitle");
        Label lbEmail = new Label(u.getEmail(), "TodayTitle");
        Label lbPhone = new Label(String.valueOf(u.getPhone()), "TodayTitle");
        Label lbRole = new Label(u.getRole(), "TodayTitle");

        Button deleteButton = new Button("Delete");
        deleteButton.setUIID("DeleteProfil");
        deleteButton.addActionListener(e -> {
            if (Dialog.show("Delete User", "Do you really want to delete this user?", "Yes", "No")) {
                int result = us.deleteUser(u.getId());
                if (result == 200) {
                    Dialog.show("Success", "User deleted", "OK", null);
                    new SettingsFormAdmin(res).show();
                } else {
                    Dialog.show("ERROR", "Server error", "OK", null);
                }
            }

        });

        Button userButton = new Button("Make User");
        userButton.setUIID("ProfilButton");
        userButton.addActionListener(e -> {
            int result = us.makeUser(u.getId());
            if (result == 200) {
                Dialog.show("Success", "Changed role to User", "OK", null);
                lbRole.setText("User");
            } else {
                Dialog.show("ERROR", "Server error", "OK", null);
            }
        });

        Button moderatorButton = new Button("Make Moderator");
        moderatorButton.setUIID("ProfilButton");
        moderatorButton.addActionListener(e -> {
            int result = us.makeModerator(u.getId());
            if (result == 200) {
                Dialog.show("Success", "Changed role to Moderator", "OK", null);
                lbRole.setText("Moderator");
            } else {
                Dialog.show("ERROR", "Server error", "OK", null);
            }
        });

        Container cntButtons = BoxLayout.encloseXCenter(
                BorderLayout.center(userButton),
                BorderLayout.center(moderatorButton),
                BorderLayout.center(deleteButton)
        );

        addAll(
                BorderLayout.center(lbCin),
                BorderLayout.center(lbFirst),
                BorderLayout.center(lbLast),
                BorderLayout.center(lbEmail),
                BorderLayout.center(lbPhone),
                BorderLayout.center(lbRole),
                BorderLayout.center(cntButtons)
        );

        setupSideMenu(res);
    }

    private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(), first));
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }

    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if (first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new SettingsForm(res).show();
    }
}
