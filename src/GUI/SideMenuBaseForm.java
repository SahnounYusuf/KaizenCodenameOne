package GUI;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import entities.User;
import utils.StaticVars;

/**
 *
 * @author Sahnoun Yusuf
 */
public abstract class SideMenuBaseForm extends Form {

    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public void setupSideMenu(Resources res) {

        User u = StaticVars.getCurrentUser();

        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(" " + u.getPrenom(), profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");

        getToolbar().addComponentToSideMenu(sidemenuTop);
        getToolbar().addMaterialCommandToSideMenu("  Dashboard", FontImage.MATERIAL_DASHBOARD, e -> {
            new PostListForm(res).show();
        });
        getToolbar().addMaterialCommandToSideMenu("  Rent", FontImage.MATERIAL_MONEY, e -> {
            new BlankForm(res).show();
        });
        getToolbar().addMaterialCommandToSideMenu("  Bicycle", FontImage.MATERIAL_BIKE_SCOOTER, e -> {
            new veloAddForm(res).show();
        });
        getToolbar().addMaterialCommandToSideMenu("  Piece", FontImage.MATERIAL_CHECKLIST, e -> {
            new PieceAddForm(res).show();
        });
        getToolbar().addMaterialCommandToSideMenu("  Event", FontImage.MATERIAL_EVENT, e -> {
            new ListEvent().show();
        });
        
        getToolbar().addMaterialCommandToSideMenu("  Account Settings", FontImage.MATERIAL_SETTINGS, e -> {
            if (u.getRole().equals("Admin")) {
                new SettingsFormAdmin(res).show();
            } else if (u.getRole().equals("Moderator")) {
                new SettingsFormAdmin(res).show();
            } else {
                new SettingsForm(res).show();
            }
        });
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> new LoginF(res).show());
    }

    protected abstract void showOtherForm(Resources res);

}
