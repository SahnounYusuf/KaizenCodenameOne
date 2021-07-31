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
import entities.Event;
import entities.Participant;
import entities.User;
import services.ServiceEvent;
import services.ServiceParticipant;
import services.UserService;
import utils.StaticVars;

/**
 * GUI builder created Form
 *
 * @author Yassine
 */
public class ListEvent extends SideMenuBaseForm  {

    public ListEvent() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public ListEvent(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        super(new BorderLayout());
        
        initGuiBuilderComponents(resourceObjectInstance);

        UserService us = new UserService();
//        setUIID("SettingsForm");
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
        this.getToolbar().addMaterialCommandToRightBar("Add Event", FontImage.MATERIAL_ADD,3, ev->
                new AddEvent().show());
        

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
                                                new Label(" Events", "WelcomeWhite"),
                                                new Label("", "WelcomeWhite")
                                        )));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        setupSideMenu(resourceObjectInstance);

        gui_Container.setScrollableY(true);

        for (Event e : new ServiceEvent().getEvent()) {
            //this.add(getEvent(p));
            Button mb = new Button(e.getEvent_name());
            mb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //Dialog.show("test", "personne avec l'id "+p.getId(), "OK", null);
                    DetailsEvent detevt = new DetailsEvent();
//                       detevt.gui_id.setText(String.valueOf(e.getId()));
                    detevt.gui_event_name.setText(e.getEvent_name());
                    detevt.gui_date.setText(e.getDate());
                    detevt.gui_heure.setText(e.getHeure());
                    detevt.gui_place.setText(e.getPlace());
                    System.out.println(e.getIdu());
                    detevt.evt = e;
                    
                    
                     User u = StaticVars.getCurrentUser();
        System.out.println(u.getId()+" "+e.getIdu());
        if(u.getId()==e.getIdu()){
           detevt.gui_BtnUpdateEvent.setEnabled(true);
           detevt.gui_BtnDeleteEvent.setEnabled(true);
           detevt.gui_BtnParticipate.setEnabled(false);
        }else{
           detevt.gui_BtnUpdateEvent.setEnabled(false);
           detevt.gui_BtnDeleteEvent.setEnabled(false);
           detevt.gui_BtnParticipate.setEnabled(true);
            
        }
                    
               System.out.println("hello"+e.getId());   
        for (Participant p : new ServiceParticipant().selectParticipant(e.getId())){
            User usr = new User();
            usr=new ServiceParticipant().getInfoParticipant(p.getIdu());
            System.out.println(usr.getNom());
            Label lb =new Label(usr.getNom()+" "+usr.getPrenom());
            
            detevt.gui_Container_Participants.add(lb);
            
        }
        
        
                    System.out.println((new ServiceParticipant().verifyParticipant(e.getId(),u.getId())).isEmpty());
            if( (new ServiceParticipant().verifyParticipant(e.getId(),u.getId())).isEmpty()){
                detevt.gui_BtnParticipate.setText("participate");
            }else{
                detevt.gui_BtnParticipate.setText("Quit Event");
            }
                
            
            
       
        
                    
                    detevt.show();
                }
            });
            gui_Container.add(mb);
        }
//        for(int i=0;i<100;i++)
//        {
//            MultiButton mb=new MultiButton("list "+i);
//            mb.setTextLine2("det");
//            gui_Container.add(mb);
//        }
    }

//////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_BtnAddEvent = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnAddEvent.addActionListener(callback);
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

            if(sourceComponent == gui_BtnAddEvent) {
                onBtnAddEventActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ListEvent");
        setName("ListEvent");
        gui_Container.setPreferredSizeStr("215.07198mm 136.53683mm");
        gui_Container.setScrollableY(false);
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_Container_1.setPreferredSizeStr("215.07198mm 11.642675mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        addComponent(gui_Container);
        addComponent(gui_Container_1);
        gui_BtnAddEvent.setText("Add Event");
                gui_BtnAddEvent.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnAddEvent.setName("BtnAddEvent");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnAddEvent,"\ue145".charAt(0));
        gui_Container_1.addComponent(gui_BtnAddEvent);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "82.73736% 0.0mm 17.146486mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnAddEventActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new AddEvent().show();
    }
    
    @Override
    protected void showOtherForm(Resources res) {
    }

}
