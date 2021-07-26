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
import com.codename1.util.StringUtil;
import entities.Event;
import services.ServiceEvent;
import java.io.IOException;
import java.util.List;

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

////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_event_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_date = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_heure = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_place = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnUpdateEvent = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnDeleteEvent = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnParticipate = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnShowMap = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
        gui_BtnUpdateEvent.addActionListener(callback);
        gui_BtnDeleteEvent.addActionListener(callback);
        gui_BtnParticipate.addActionListener(callback);
        gui_BtnShowMap.addActionListener(callback);
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

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
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
        gui_Label.setPreferredSizeStr("24.767147mm inherit");
        gui_Label.setText("Event Name");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("26.037256mm inherit");
        gui_Label_1.setText("Date");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("23.920406mm inherit");
        gui_Label_2.setText("Heure");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("22.650297mm inherit");
        gui_Label_3.setText("Place");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_event_name.setPreferredSizeStr("53.97968mm 6.1388655mm");
        gui_event_name.setText("1");
                gui_event_name.setInlineStylesTheme(resourceObjectInstance);
        gui_event_name.setName("event_name");
        gui_date.setPreferredSizeStr("53.13294mm 6.1388655mm");
        gui_date.setText("1");
                gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setName("date");
        gui_heure.setPreferredSizeStr("52.497883mm 6.1388655mm");
        gui_heure.setText("1");
                gui_heure.setInlineStylesTheme(resourceObjectInstance);
        gui_heure.setName("heure");
        gui_place.setPreferredSizeStr("52.497883mm 6.1388655mm");
        gui_place.setText("");
                gui_place.setInlineStylesTheme(resourceObjectInstance);
        gui_place.setName("place");
        gui_Button.setText("Back");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_BtnUpdateEvent.setText("Update Event");
                gui_BtnUpdateEvent.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnUpdateEvent.setName("BtnUpdateEvent");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnUpdateEvent,"\ue923".charAt(0));
        gui_BtnDeleteEvent.setText("Delete");
                gui_BtnDeleteEvent.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnDeleteEvent.setName("BtnDeleteEvent");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnDeleteEvent,"\ue872".charAt(0));
        gui_BtnParticipate.setText("Participate");
                gui_BtnParticipate.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnParticipate.setName("BtnParticipate");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnParticipate,"\ue3ba".charAt(0));
        gui_BtnShowMap.setText("Show Map");
                gui_BtnShowMap.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnShowMap.setName("BtnShowMap");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnShowMap,"\ue41b".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_Label_3);
        addComponent(gui_event_name);
        addComponent(gui_date);
        addComponent(gui_heure);
        addComponent(gui_place);
        addComponent(gui_Button);
        addComponent(gui_BtnUpdateEvent);
        addComponent(gui_BtnDeleteEvent);
        addComponent(gui_BtnParticipate);
        addComponent(gui_BtnShowMap);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "9.02811% auto auto 1.2701101mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "4.2337mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_1, "0 3 -1 0 ").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "58.01105% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_2, "0 0 3 0 ").setReferencePositions(gui_Label_2, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "25.759846% 4.8687525mm auto 0.0mm").setReferenceComponents(gui_Label_3, "0 4 -1 0 ").setReferencePositions(gui_Label_3, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_event_name.getParent().getLayout()).setInsets(gui_event_name, "64.242615% 2.7519052mm 0.0mm 34.153954%").setReferenceComponents(gui_event_name, "-1 -1 0 -1").setReferencePositions(gui_event_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_date.getParent().getLayout()).setInsets(gui_date, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_date, "-1 4 1 4 ").setReferencePositions(gui_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_heure.getParent().getLayout()).setInsets(gui_heure, "86.59514% 1.4817951mm -1.4817952mm 0.0mm").setReferenceComponents(gui_heure, "-1 4 2 4 ").setReferencePositions(gui_heure, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_place.getParent().getLayout()).setInsets(gui_place, "1.2701111mm 0.0mm -1.2701101mm 0.0mm").setReferenceComponents(gui_place, "3 6 3 4 ").setReferencePositions(gui_place, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "2.1168509mm 0.0mm auto auto").setReferenceComponents(gui_Button, "-1 4 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnUpdateEvent.getParent().getLayout()).setInsets(gui_BtnUpdateEvent, "auto 0.0mm 9.949196mm auto").setReferenceComponents(gui_BtnUpdateEvent, "-1 0 -1 -1").setReferencePositions(gui_BtnUpdateEvent, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnDeleteEvent.getParent().getLayout()).setInsets(gui_BtnDeleteEvent, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_BtnDeleteEvent, "9 12 -1 -1").setReferencePositions(gui_BtnDeleteEvent, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnParticipate.getParent().getLayout()).setInsets(gui_BtnParticipate, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_BtnParticipate, "9 6 9 10 ").setReferencePositions(gui_BtnParticipate, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnShowMap.getParent().getLayout()).setInsets(gui_BtnShowMap, "13.372093% 0.0mm auto auto").setReferenceComponents(gui_BtnShowMap, "7 8 -1 -1").setReferencePositions(gui_BtnShowMap, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
       new ListEvent().show();
    }

    public void onBtnUpdateEventActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        UpdateEvent updevent = new UpdateEvent();
        updevent.evtupdate =evt;
        updevent.gui_event_name.setText(gui_event_name.getText());
        updevent.gui_date.setText(gui_date.getText());
        updevent.gui_heure.setText(gui_heure.getText());
        updevent.gui_place.setText(gui_place.getText());
        
        
         
        updevent.show();
    }

    public void onBtnDeleteEventActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Event p = new Event(evt.getId(), 3, gui_event_name.getText(), gui_date.getText(), gui_heure.getText(), gui_place.getText());
                    ServiceEvent sp = new ServiceEvent();
                    if (sp.deleteEvent(p) == 200) {

                        Dialog.show("SUCCESS", "Event Deleted", "OK", null);
                        
                        new ListEvent().show();
                    } else {

                     Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);   
                    }
        
    }

    public void onBtnParticipateActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

    public void onBtnShowMapActionEvent(com.codename1.ui.events.ActionEvent ev) {
        DetailsEvent dev =new DetailsEvent();
        dev.gui_event_name=gui_event_name;
        dev.gui_date=gui_date;
        dev.gui_heure=gui_heure;
        dev.gui_place=gui_place;
        ViewMap vmap = new ViewMap();
        vmap.de=dev;
        
        
        List<String> arrSplit = StringUtil.tokenize(vmap.de.gui_place.getText(),",");
           Coord lastLocation = new Coord( Double.valueOf(arrSplit.get(0)),Double.valueOf(arrSplit.get(1)));
         
           //Coord lastLocation = new Coord(36.7949999, 10.0732379);
           try { 
            Image i = Image.createImage("/blue_pin.png");
            PointsLayer pl = new PointsLayer();
            pl.setPointIcon(i);
            PointLayer p = new PointLayer(lastLocation,vmap.de.gui_event_name.getText(), i);
            
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
