/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.maps.Coord;
import com.codename1.maps.MapComponent;
import com.codename1.maps.layers.PointLayer;
import com.codename1.maps.layers.PointsLayer;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.util.StringUtil;
import entities.Event;
import entities.Participant;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import services.ServiceEvent;
import services.ServiceParticipant;
import utils.StaticVars;


/**
 * GUI builder created Form
 *
 * @author Yassine
 */
public class ViewMap extends com.codename1.ui.Form {
    MapComponent mc = new MapComponent();
    DetailsEvent de = new DetailsEvent();
    Event ee =new Event();

    public ViewMap() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ViewMap(com.codename1.ui.util.Resources resourceObjectInstance) {
        
            initGuiBuilderComponents(resourceObjectInstance);
          

    }
    
    
//////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_BtnReturn = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_map = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnReturn.addActionListener(callback);
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

            if(sourceComponent == gui_BtnReturn) {
                onBtnReturnActionEvent(ev);
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
        setTitle("View Map");
        setName("ViewMap");
        gui_BtnReturn.setText("Return");
                gui_BtnReturn.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnReturn.setName("BtnReturn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnReturn,"\ue31b".charAt(0));
        gui_Container_2.setPreferredSizeStr("111.34631mm 158.3404mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        addComponent(gui_BtnReturn);
        addComponent(gui_Container_2);
        gui_map.setPreferredSizeStr("109.441154mm 153.25995mm");
                gui_map.setInlineStylesTheme(resourceObjectInstance);
        gui_map.setName("map");
        gui_Container_2.addComponent(gui_map);
        ((com.codename1.ui.layouts.LayeredLayout)gui_map.getParent().getLayout()).setInsets(gui_map, "0px 0.0mm 0.0mm 0px").setReferenceComponents(gui_map, "-1 -1 -1 -1").setReferencePositions(gui_map, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnReturn.getParent().getLayout()).setInsets(gui_BtnReturn, "auto 7.490637% 6.1388655mm auto").setReferenceComponents(gui_BtnReturn, "-1 -1 -1 -1").setReferencePositions(gui_BtnReturn, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)215.07198);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)158.3404);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0px 0px 0.0mm 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 0 -1").setReferencePositions(gui_Container_2, "0.0 0.0 1.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnReturnActionEvent(com.codename1.ui.events.ActionEvent ev) {
        DetailsEvent devent =new DetailsEvent();
        devent.gui_event_name.setText(de.gui_event_name.getText());
        devent.gui_date.setText(de.gui_date.getText());
        devent.gui_heure.setText(de.gui_heure.getText());
        devent.gui_place.setText(de.gui_place.getText());
        devent.evt=ee;
        
        List<String> st =StringUtil.tokenize(ee.getPlace(),",");
        devent.gui_Textgeorev.setText(new ServiceEvent().getAdress(st.get(0),st.get(1)));
                    
        
        User u = StaticVars.getCurrentUser();
        System.out.println(u.getId()+" "+ee.getIdu());
        if(u.getId()== ee.getIdu()){
           devent.gui_BtnUpdateEvent.setEnabled(true);
           devent.gui_BtnDeleteEvent.setEnabled(true);
           
        }else{
           devent.gui_BtnUpdateEvent.setEnabled(false);
           devent.gui_BtnDeleteEvent.setEnabled(false);
          
            
        }
        
        for (Participant pp : new ServiceParticipant().selectParticipant(ee.getId())) {
                    User usr = new User();
                    usr = new ServiceParticipant().getInfoParticipant(pp.getIdu());
                    System.out.println(usr.getNom());
                    Label lb = new Label(usr.getNom() + " " + usr.getPrenom());

                    devent.gui_Container_Participants.add(lb);

                }
        
        devent.show();
    }

}
