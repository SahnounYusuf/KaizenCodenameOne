package GUI;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entities.User;
import java.util.ArrayList;
import services.UserService;
import utils.StaticVars;

/**
 *
 * @author Sahnoun Yusuf
 */
public class LoginF extends Form {

    public LoginF(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome ", "WelcomeWhite"),
                new Label("Abord", "WelcomeBlue")
        );

        getTitleArea().setUIID("Container");

//        Image profilePic = theme.getImage("LogoVelo.jpg");
//        Image mask = theme.getImage("round-mask.png");
//        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
//        Label profilePicLabel = new Label(profilePic, "ProfilePic");
//        profilePicLabel.setMask(mask.createMask());
        TextField login = new TextField("1", "Login", 20, TextField.EMAILADDR);
        TextField password = new TextField("123", "Password", 20, TextField.PASSWORD);

        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);

        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");

        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);

        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);

        Button fbButton = new Button("Continue with Facebook");
//        fbButton.setMaterialIcon(FontImage.MATERIAL_FACEBOOK, 3);
        fbButton.setUIID("FacebookButton");

        Button loginButton = new Button("Login");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
//            Toolbar.setGlobalToolbar(false);
            UserService us = new UserService();
            ArrayList<User> u = us.verifyUser(login.getText(), password.getText());
            if (!u.isEmpty()) {
                StaticVars.setCurrentUser(u.get(0));
                new BlankForm(theme).show();
            } else {
                Dialog.show("ERROR", "Wrong Cin/Password", "OK", null);
            }
//            Toolbar.setGlobalToolbar(true);
        }
        );

        Button createNewAccount = new Button("CREATE NEW ACCOUNT");

        createNewAccount.setUIID(
                "CreateNewAccountButton");
        createNewAccount.addActionListener(e
                -> {
//            Toolbar.setGlobalToolbar(false);
            new RegisterForm(theme).show();
//            Toolbar.setGlobalToolbar(true);
        }
        );

        Button btnForget = new Button("Forget Password?");

        btnForget.setUIID("CreateNewAccountButton");
        btnForget.addActionListener(e -> {
            new ForgetForm(theme).show();
        });

        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;

        if (!Display.getInstance()
                .isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }

        Container by = BoxLayout.encloseY(
                welcome,
                //                profilePicLabel,
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton,
                fbButton,
                createNewAccount,
                btnForget
        );

        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(
                true);
        by.setScrollVisible(
                false);
    }
}
