package GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
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
import entities.UserState;
import services.UserService;

/**
 *
 * @author Sahnoun Yusuf
 */
public class ProfileForm extends SideMenuBaseForm {
    
    String lastLogin = "";
    
    public ProfileForm(Resources res, User u) {
        super(BoxLayout.y());
//        setUIID("SettingsForm");
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
        float count = Float.valueOf(us.retriveUserCountLogin(String.valueOf(u.getId())).get(0));
        Container remainingTasks = BoxLayout.encloseY(
                new Label(String.valueOf(count), "CenterTitle"),
                new Label("Opened the app", "CenterSubTitle")
        );
        remainingTasks.setUIID("RemainingTasks");
        
        if (us.retriveUserLastLogin(String.valueOf(u.getId())).isEmpty()) {
            lastLogin = "-";
        } else {
            lastLogin = us.retriveUserLastLogin(String.valueOf(u.getId())).get(0);
        }
        
        Container completedTasks = BoxLayout.encloseY(
                new Label(lastLogin, "CenterTitle"),
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

        //================================================
        Label starIcon = new Label("", "StatTextField");
        Label flagIcon = new Label("", "StatTextField");
        Label reportIcon = new Label("", "StatTextField");
        
        starIcon.getAllStyles().setMargin(LEFT, 5);
        flagIcon.getAllStyles().setMargin(LEFT, 2);
        reportIcon.getAllStyles().setMargin(LEFT, 2);
        
        FontImage.setMaterialIcon(starIcon, FontImage.MATERIAL_STAR, 2);
        FontImage.setMaterialIcon(flagIcon, FontImage.MATERIAL_FLAG, 2);
        FontImage.setMaterialIcon(reportIcon, FontImage.MATERIAL_REPORT, 2);
        
        Label lbStar = new Label("Trust: " + us.retriveUserState(String.valueOf(u.getId())).get(0).getStar() + "         |");
        Label lbFlag = new Label("Reports: " + us.retriveUserState(String.valueOf(u.getId())).get(0).getFlag() + "         |");
        Label lbReport = new Label("Banned: " + us.retriveUserState(String.valueOf(u.getId())).get(0).getBlock() + "         ");
        
        Container cntStat = BoxLayout.encloseX(
                BorderLayout.east(lbStar).
                        add(BorderLayout.CENTER, starIcon),
                BorderLayout.center(lbFlag).
                        add(BoxLayout.X_AXIS, flagIcon),
                BorderLayout.center(lbReport).
                        add(BorderLayout.WEST, reportIcon)
        );
        
        lbStar.setUIID("StatTextField");
        lbFlag.setUIID("StatTextField");
        lbReport.setUIID("StatTextField");

        // ========================================================
        if (us.retriveUserState(String.valueOf(u.getId())).isEmpty()) {
            UserState userState = new UserState();
            userState.setIdu(u.getId());
            userState.setStar(0);
            userState.setFlag(0);
            userState.setBlock("No");
            us.addState(userState);
        }
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.createSubFAB(FontImage.MATERIAL_STAR, "").addActionListener((evt) -> {
            UserState userState = new UserState();
            userState.setIdu(u.getId());
            userState.setStar(us.retriveUserState(String.valueOf(u.getId())).get(0).getStar() + 1);
            userState.setFlag(us.retriveUserState(String.valueOf(u.getId())).get(0).getFlag());
            userState.setBlock(us.retriveUserState(String.valueOf(u.getId())).get(0).getBlock());
            us.UpdateState(userState);
            lbStar.setText("Trust: " + us.retriveUserState(String.valueOf(u.getId())).get(0).getStar() + "         |");
        });
        fab.createSubFAB(FontImage.MATERIAL_FLAG, "").addActionListener((evt) -> {
            UserState userState = new UserState();
            userState.setIdu(u.getId());
            userState.setStar(us.retriveUserState(String.valueOf(u.getId())).get(0).getStar());
            userState.setFlag(us.retriveUserState(String.valueOf(u.getId())).get(0).getFlag() + 1);
            userState.setBlock(us.retriveUserState(String.valueOf(u.getId())).get(0).getBlock());
            us.UpdateState(userState);
            lbFlag.setText("Reports: " + us.retriveUserState(String.valueOf(u.getId())).get(0).getFlag() + "         |");
        });
        fab.createSubFAB(FontImage.MATERIAL_REPORT, "").addActionListener((evt) -> {
            UserState userState = new UserState();
            userState.setIdu(u.getId());
            userState.setStar(us.retriveUserState(String.valueOf(u.getId())).get(0).getStar());
            userState.setFlag(us.retriveUserState(String.valueOf(u.getId())).get(0).getFlag());
            if (us.retriveUserState(String.valueOf(u.getId())).get(0).getBlock().equals("No")) {
                userState.setBlock("Yes");
            }else {
                userState.setBlock("No");
            }
            us.UpdateState(userState);
            lbReport.setText("Banned: " + us.retriveUserState(String.valueOf(u.getId())).get(0).getBlock() + "         ");
        });
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
        
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
                if (u.getRole().equals("Admin")) {
                    Dialog.show("Error", "This actions can't be made!", "Ok", null);
                    return;
                } else {
                    int result = us.deleteUser(u.getId());
                    if (result == 200) {
                        Dialog.show("Success", "User deleted", "OK", null);
                        new SettingsFormAdmin(res).show();
                    } else {
                        Dialog.show("ERROR", "Server error", "OK", null);
                    }
                }
            }
            
        });
        
        Button userButton = new Button("Make User");
        userButton.setUIID("ProfilButton");
        userButton.addActionListener(e -> {
            int result = us.makeUser(u.getId());
            System.out.println(u.getRole());
            if (u.getRole().equals("Admin")) {
                Dialog.show("Error", "This actions can't be made!", "Ok", null);
                return;
            } else {
                if (result == 200) {
                    Dialog.show("Success", "Changed role to User", "OK", null);
                    lbRole.setText("User");
                } else {
                    Dialog.show("ERROR", "Server error", "OK", null);
                }
            }
        });
        
        Button moderatorButton = new Button("Make Moderator");
        moderatorButton.setUIID("ProfilButton");
        moderatorButton.addActionListener(e -> {
            if (u.getRole().equals("Admin")) {
                Dialog.show("Error", "This actions can't be made!", "Ok", null);
                return;
            } else {
                int result = us.makeModerator(u.getId());
                if (result == 200) {
                    Dialog.show("Success", "Changed role to Moderator", "OK", null);
                    lbRole.setText("Moderator");
                } else {
                    Dialog.show("ERROR", "Server error", "OK", null);
                }
            }
        });
        
        Container cntButtons = BoxLayout.encloseXCenter(
                BorderLayout.center(userButton),
                BorderLayout.center(moderatorButton),
                BorderLayout.center(deleteButton)
        );
        
        addAll(
                BorderLayout.center(cntStat),
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
    
    @Override
    protected void showOtherForm(Resources res) {
        new SettingsForm(res).show();
    }
}
