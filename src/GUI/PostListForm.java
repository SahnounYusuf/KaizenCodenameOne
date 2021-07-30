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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entities.User;
import entities.comments;
import entities.post;
import services.PostService;
import services.UserService;
import utils.StaticVars;

/**
 * GUI builder created Form
 *
 * @author muhamed
 */
public class PostListForm extends SideMenuBaseForm {

    public PostListForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public PostListForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        super(new BorderLayout());
        initGuiBuilderComponents(resourceObjectInstance);

        Toolbar tb = this.getToolbar();
        tb.setTitleCentered(false);
        User u = StaticVars.getCurrentUser();
        Image profilePic = resourceObjectInstance.getImage("user-picture.jpg");
        Image tintedImage = Image.createImage(profilePic.getWidth(), profilePic.getHeight());
        Graphics g = tintedImage.getGraphics();
        g.drawImage(profilePic, 0, 0);
        g.drawImage(resourceObjectInstance.getImage("gradient-overlay.png"), 0, 0, profilePic.getWidth(), profilePic.getHeight());

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
                                                new Label(" Dashbord", "WelcomeWhite"),
                                                new Label("", "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        setupSideMenu(resourceObjectInstance);
        
        
        
        tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, ev
                -> System.out.println("add post"));
        gui_cntPost.setLayout(BoxLayout.y());
        for (post p : new services.PostService().getpost()) {
            Label lbNom = new Label(p.getPostedby());
            Label lbDesc = new Label(p.getDescription());
            System.out.println(p);
            lbNom.setUIID("PostTextField");
            lbDesc.setUIID("PostTextField");
            Label vide = new Label("       ");

            Container cntDescName = BoxLayout.encloseY(lbNom, lbDesc, vide);
            gui_cntPost.add(cntDescName);
        }
        Button btnPost = new Button();
        btnPost.setText("Add Post");
        btnPost.setUIID("PostTextField");
        btnPost.getAllStyles().setBgColor(0x1877f2);
        btnPost.getAllStyles().setFgColor(0x1877f2);
        btnPost.addActionListener(e -> {
            new PostAddForm(resourceObjectInstance).show();
        });
        gui_cntPost.add(btnPost);
        gui_cntPost.setScrollableX(true);

    }
//////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_cntPost = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_BtnAddPost = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnAddPost.addActionListener(callback);
    }

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_BtnAddPost) {
                onBtnAddPostActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("listpost");
        setName("listpost");
        gui_cntPost.setPreferredSizeStr("189.41798mm 107.40741mm");
                gui_cntPost.setInlineStylesTheme(resourceObjectInstance);
        gui_cntPost.setName("cntPost");
        gui_Container_1.setPreferredSizeStr("189.41798mm 13.4920635mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        addComponent(gui_cntPost);
        addComponent(gui_Container_1);
        gui_BtnAddPost.setPreferredSizeStr("30.15873mm 9.523809mm");
        gui_BtnAddPost.setText("AddPost");
                gui_BtnAddPost.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnAddPost.setName("BtnAddPost");
        gui_Container_1.addComponent(gui_BtnAddPost);
        ((com.codename1.ui.layouts.LayeredLayout)gui_cntPost.getLayout()).setPreferredWidthMM((float)189.41798);
        ((com.codename1.ui.layouts.LayeredLayout)gui_cntPost.getLayout()).setPreferredHeightMM((float)107.40741);
        ((com.codename1.ui.layouts.LayeredLayout)gui_cntPost.getParent().getLayout()).setInsets(gui_cntPost, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_cntPost, "-1 -1 1 -1").setReferencePositions(gui_cntPost, "0.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "76.315796% 0.0mm 14.097744% 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnAddPostActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new PostListForm().show();
    }

}
