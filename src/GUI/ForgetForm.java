/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Sahnoun Yusuf
 */
public class ForgetForm extends Form {

    public ForgetForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Enter your Email or phone number ", "WelcomeWhite"),
                new Label("", "WelcomeBlue")
        );

        getTitleArea().setUIID("Container");

        TextField tfCin = new TextField("", "Cin number");

        tfCin.setUIID("RegisterTextField");

        tfCin.getAllStyles().setMargin(LEFT, 0);

        Button registerButton = new Button("Send password");
        registerButton.setUIID("LoginButton");
        registerButton.addActionListener(e -> {
            Toolbar.setGlobalToolbar(false);

            Dialog.show("SUCCESS", "Welcome to the family", "OK", null);

            Dialog.show("ERROR", "Oops! something went wrong.", "OK", null);

//            new WalkthruForm(theme).show();
            Toolbar.setGlobalToolbar(true);
        });

        Button btnAlreadyHava = new Button("Go to Login Page");
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
                registerButton,
                btnAlreadyHava
        );
        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);

    }
}
