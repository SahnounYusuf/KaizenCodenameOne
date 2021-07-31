/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.maps.Coord;
import com.codename1.maps.layers.PointLayer;
import com.codename1.maps.layers.PointsLayer;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.util.StringUtil;
import entities.Event;
import entities.Participant;
import entities.User;
import services.ServiceEvent;
import java.io.IOException;
import java.util.List;
import services.ServiceParticipant;
import utils.StaticVars;

/**
 * GUI builder created Form
 *
 * @author Yassine
 */
public class DetailsEvent extends com.codename1.ui.Form {

    Event evt = new Event();

    public DetailsEvent() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public DetailsEvent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_ContainerBTN = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_BtnUpdateEvent = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnDeleteEvent = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnParticipate = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_event_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_date = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_heure = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_place = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_BtnShowMap = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_participant = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_Participants = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnUpdateEvent.addActionListener(callback);
        gui_BtnDeleteEvent.addActionListener(callback);
        gui_BtnParticipate.addActionListener(callback);
        gui_BtnShowMap.addActionListener(callback);
        gui_Button.addActionListener(callback);
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

            if(sourceComponent == gui_BtnUpdateEvent) {
                onBtnUpdateEventActionEvent(ev);
            }
            if(sourceComponent == gui_BtnDeleteEvent) {
                onBtnDeleteEventActionEvent(ev);
            }
            if(sourceComponent == gui_BtnParticipate) {
                onBtnParticipateActionEvent(ev);
            }
            if(sourceComponent == gui_BtnShowMap) {
                onBtnShowMapActionEvent(ev);
            }
            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
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
        setInlineAllStyles("alignment:center;");
        setTitle("Details Event");
        setName("DetailsEvent");
        gui_ContainerBTN.setPreferredSizeStr("214.01355mm 25.4022mm");
                gui_ContainerBTN.setInlineStylesTheme(resourceObjectInstance);
        gui_ContainerBTN.setInlineAllStyles("margin:inherit inherit inherit 40px;");
        gui_ContainerBTN.setName("ContainerBTN");
        gui_Container.setPreferredSizeStr("inherit 31.75275230407715mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_Container_1.setPreferredSizeStr("inherit 38.526672mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("213.59018mm 10.160881mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_3.setPreferredSizeStr("215.07198mm 8.890771mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_Participants.setPreferredSizeStr("215.07198mm 74.93649mm");
        gui_Container_Participants.setScrollableX(true);
                gui_Container_Participants.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_Participants.setName("Container_Participants");
        addComponent(gui_ContainerBTN);
        gui_BtnUpdateEvent.setText("Update");
                gui_BtnUpdateEvent.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnUpdateEvent.setName("BtnUpdateEvent");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnUpdateEvent,"\ue923".charAt(0));
        gui_BtnDeleteEvent.setPreferredSizeStr("inherit 8.890771mm");
        gui_BtnDeleteEvent.setText("Delete");
                gui_BtnDeleteEvent.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnDeleteEvent.setName("BtnDeleteEvent");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnDeleteEvent,"\ue872".charAt(0));
        gui_BtnParticipate.setPreferredSizeStr("inherit 8.467401mm");
        gui_BtnParticipate.setText("Participate");
                gui_BtnParticipate.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnParticipate.setName("BtnParticipate");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnParticipate,"\ue3ba".charAt(0));
        gui_ContainerBTN.addComponent(gui_BtnUpdateEvent);
        gui_ContainerBTN.addComponent(gui_BtnDeleteEvent);
        gui_ContainerBTN.addComponent(gui_BtnParticipate);
        addComponent(gui_Container);
        gui_event_name.setPreferredSizeStr("101.18544mm 6.1388655mm");
        gui_event_name.setText("1");
                gui_event_name.setInlineStylesTheme(resourceObjectInstance);
        gui_event_name.setName("event_name");
        gui_date.setPreferredSizeStr("101.18544mm 6.1388655mm");
        gui_date.setText("1");
                gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setName("date");
        gui_heure.setPreferredSizeStr("101.18544mm 6.1388655mm");
        gui_heure.setText("1");
                gui_heure.setInlineStylesTheme(resourceObjectInstance);
        gui_heure.setName("heure");
        gui_place.setPreferredSizeStr("101.18544mm 6.1388655mm");
        gui_place.setText("1");
                gui_place.setInlineStylesTheme(resourceObjectInstance);
        gui_place.setName("place");
        gui_Container.addComponent(gui_event_name);
        gui_Container.addComponent(gui_date);
        gui_Container.addComponent(gui_heure);
        gui_Container.addComponent(gui_place);
        addComponent(gui_Container_1);
        gui_Label.setPreferredSizeStr("24.767147mm inherit");
        gui_Label.setText("Event Name");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("margin:inherit inherit 3px inherit;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("24.767147mm inherit");
        gui_Label_1.setText("Date");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("margin:inherit inherit 3px inherit;");
        gui_Label_1.setInlineSelectedStyles("opacity:0;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("24.767147mm inherit");
        gui_Label_2.setText("Heure");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("margin:inherit inherit 3px inherit;");
        gui_Label_2.setInlineDisabledStyles("opacity:0;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("24.767147mm inherit");
        gui_Label_3.setText("Place");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("margin:inherit inherit 3px inherit;");
        gui_Label_3.setName("Label_3");
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_Label_3);
        addComponent(gui_Container_2);
        gui_BtnShowMap.setPreferredSizeStr("inherit 14.606266mm");
        gui_BtnShowMap.setText("Show Map");
                gui_BtnShowMap.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnShowMap.setName("BtnShowMap");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnShowMap,"\ue41b".charAt(0));
        gui_Label_participant.setPreferredSizeStr("inherit 9.102455mm");
        gui_Label_participant.setText("Participants");
                gui_Label_participant.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_participant.setName("Label_participant");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Label_participant,"\ue7fb".charAt(0));
        gui_Container_2.addComponent(gui_BtnShowMap);
        gui_Container_2.addComponent(gui_Label_participant);
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnShowMap.getParent().getLayout()).setInsets(gui_BtnShowMap, "0.0mm 1.0584259mm 0.0mm auto").setReferenceComponents(gui_BtnShowMap, "-1 -1 -1 -1").setReferencePositions(gui_BtnShowMap, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_participant.getParent().getLayout()).setInsets(gui_Label_participant, "-0.21168502mm auto auto 0.42337036mm").setReferenceComponents(gui_Label_participant, "-1 -1 -1 -1").setReferencePositions(gui_Label_participant, "0.0 0.0 0.0 0.0");
        addComponent(gui_Container_3);
        gui_Button.setPreferredSizeStr("inherit 8.04403mm");
        gui_Button.setText("Back");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_Container_3.addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "0.0mm 1.058424mm 0.0mm auto").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        addComponent(gui_Container_Participants);
        ((com.codename1.ui.layouts.LayeredLayout)gui_ContainerBTN.getParent().getLayout()).setInsets(gui_ContainerBTN, "0.0mm 0.0mm auto 1.4817951mm").setReferenceComponents(gui_ContainerBTN, "5 1 -1 -1").setReferencePositions(gui_ContainerBTN, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 74.5098% 0.0mm").setReferenceComponents(gui_Container, "2 -1 -1 2 ").setReferencePositions(gui_Container, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "11.960543% auto auto 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)213.59018);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)10.372565);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm 90.97744% 0.0mm").setReferenceComponents(gui_Container_2, "1 -1 -1 0 ").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)215.07198);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)8.890771);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_3, "-1 1 1 0 ").setReferencePositions(gui_Container_3, "0.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_Participants.getParent().getLayout()).setInsets(gui_Container_Participants, "40.32059% auto 16.029593% 0.0mm").setReferenceComponents(gui_Container_Participants, "-1 -1 -1 2 ").setReferencePositions(gui_Container_Participants, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new ListEvent().show();
    }

    public void onBtnUpdateEventActionEvent(com.codename1.ui.events.ActionEvent ev) {

        UpdateEvent updevent = new UpdateEvent();
        updevent.evtupdate = evt;
        updevent.gui_event_name.setText(gui_event_name.getText());
        updevent.gui_date.setText(gui_date.getText());
        updevent.gui_heure.setText(gui_heure.getText());
        updevent.gui_place.setText(gui_place.getText());

        updevent.show();
    }

    public void onBtnDeleteEventActionEvent(com.codename1.ui.events.ActionEvent ev) {
        User u = StaticVars.getCurrentUser();
        Event p = new Event(evt.getId(), u.getId(), gui_event_name.getText(), gui_date.getText(), gui_heure.getText(), gui_place.getText());
        ServiceEvent sp = new ServiceEvent();
        if (sp.deleteEvent(p) == 200) {

            Dialog.show("SUCCESS", "Event Deleted", "OK", null);

            new ListEvent().show();
        } else {

            Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);
        }

    }

    public void onBtnParticipateActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if (gui_BtnParticipate.getText().equals("Quit Event")) {

            User u = StaticVars.getCurrentUser();
            Participant p = new Participant(evt.getId(), u.getId());
            ServiceParticipant sp = new ServiceParticipant();
            if (sp.deleteParticipant(p) == 200) {

                Dialog.show("SUCCESS", "SUCCESS", "OK", null);

                new ListEvent().show();
            } else {

                Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);
            }

        } else {
            User u = StaticVars.getCurrentUser();
            Participant p = new Participant(evt.getId(), u.getId());
            ServiceParticipant sp = new ServiceParticipant();
            if (sp.addParticipant(p) == 200) {
                for (Participant pp : new ServiceParticipant().selectParticipant(evt.getId())) {
                    User usr = new User();
                    usr = new ServiceParticipant().getInfoParticipant(pp.getIdu());
                    System.out.println(usr.getNom());
                    Label lb = new Label(usr.getNom() + " " + usr.getPrenom());

                    gui_Container_Participants.add(lb);

                }
                    gui_BtnParticipate.setText("Quit Event");

                Dialog.show("SUCCESS", "SUCCESS", "OK", null);


            } else {

                Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);
            }

        }


    }

    public void onBtnShowMapActionEvent(com.codename1.ui.events.ActionEvent ev) {
        DetailsEvent dev = new DetailsEvent();
        dev.gui_event_name = gui_event_name;
        dev.gui_date = gui_date;
        dev.gui_heure = gui_heure;
        dev.gui_place = gui_place;
        ViewMap vmap = new ViewMap();
        vmap.ee = evt;
        vmap.de = dev;

        List<String> arrSplit = StringUtil.tokenize(vmap.de.gui_place.getText(), ",");
        Coord lastLocation = new Coord(Double.valueOf(arrSplit.get(0)), Double.valueOf(arrSplit.get(1)));

        //Coord lastLocation = new Coord(36.7949999, 10.0732379);
        try {
            Image i = Image.createImage("/blue_pin.png");
            PointsLayer pl = new PointsLayer();
            pl.setPointIcon(i);
            PointLayer p = new PointLayer(lastLocation, vmap.de.gui_event_name.getText(), i);

            p.setDisplayName(true);
            pl.addPoint(p);
            vmap.mc.addLayer(pl);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        vmap.mc.zoomTo(lastLocation, 16);
        vmap.gui_map.addComponent(vmap.mc);

        vmap.show();
    }

}
