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
import services.UserService;

/**
 *
 * @author Sahnoun Yusuf
 */
public class RegisterForm extends Form {

    public RegisterForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Create your account ", "WelcomeWhite"),
                new Label("", "WelcomeBlue")
        );

        getTitleArea().setUIID("Container");

        TextField tfCin = new TextField("", "Cin number");
        TextField tfFirst = new TextField("", "First Name");
        TextField tfLast = new TextField("", "Last Name");
        TextField tfEmail = new TextField("", "Email", 20, TextField.EMAILADDR);
        TextField tfPhone = new TextField("", "Phone", 20, TextField.PHONENUMBER);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        
        tfCin.setUIID("RegisterTextField");
        tfFirst.setUIID("RegisterTextField");
        tfLast.setUIID("RegisterTextField");
        tfEmail.setUIID("RegisterTextField");
        tfPhone.setUIID("RegisterTextField");
        password.setUIID("RegisterTextField");

        tfEmail.getAllStyles().setMargin(LEFT, 0);
        tfPhone.getAllStyles().setMargin(LEFT, 0);
        tfCin.getAllStyles().setMargin(LEFT, 0);
        tfFirst.getAllStyles().setMargin(LEFT, 0);
        tfLast.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);

        Button registerButton = new Button("Register");
        registerButton.setUIID("LoginButton");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            UserService us = new UserService();
            User u = new User();

            u.setNom(tfLast.getText());
            u.setPrenom(tfFirst.getText());
            u.setId(Integer.valueOf(tfCin.getText()));
            u.setEmail(tfEmail.getText());
            u.setPhone(Integer.valueOf(tfPhone.getText()));
            u.setPassword(password.getText());
            int result = us.addUser(u);
            if (result == 200) {
                Dialog.show("SUCCESS", "Welcome to the family", "OK", null);
            } else {
                Dialog.show("ERROR", "Oops! something went wrong.", "OK", null);
            }

//            new WalkthruForm(theme).show();
            Toolbar.setGlobalToolbar(true);
        });

        Button btnAlreadyHava = new Button("Already have an account?");
        btnAlreadyHava.setUIID("CreateNewAccountButton");
        btnAlreadyHava.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);
            new LoginF(theme).show();
            Toolbar.setGlobalToolbar(true);
        });

        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if (!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }

        Container by = BoxLayout.encloseY(
                welcome,
                //                profilePicLabel,
                spaceLabel,
                BorderLayout.center(tfCin),
                BorderLayout.center(tfFirst),
                BorderLayout.center(tfLast),
                BorderLayout.center(tfEmail),
                BorderLayout.center(tfPhone),
                BorderLayout.center(password),
                registerButton,
                btnAlreadyHava
        );
        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
