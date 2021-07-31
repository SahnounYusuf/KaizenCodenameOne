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
import entities.User;
import java.io.IOException;
import java.util.List;
import services.ServiceEvent;
import utils.StaticVars;

/**
 * GUI builder created Form
 *
 * @author Yassine
 */
public class UpdateEvent extends com.codename1.ui.Form {

    Event evtupdate = new Event();

    public UpdateEvent() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public UpdateEvent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
    }

////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_BtnSaveChenges = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnCancel = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.TextField gui_event_name = new com.codename1.ui.TextField();
    protected com.codename1.ui.spinner.Picker gui_date = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.spinner.Picker gui_heure = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.TextField gui_place = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_BtnUpdateMap = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnSaveChenges.addActionListener(callback);
        gui_BtnCancel.addActionListener(callback);
        gui_BtnUpdateMap.addActionListener(callback);
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

            if(sourceComponent == gui_BtnSaveChenges) {
                onBtnSaveChengesActionEvent(ev);
            }
            if(sourceComponent == gui_BtnCancel) {
                onBtnCancelActionEvent(ev);
            }
            if(sourceComponent == gui_BtnUpdateMap) {
                onBtnUpdateMapActionEvent(ev);
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
        setTitle("Update Event");
        setName("UpdateEvent");
        gui_Container.setPreferredSizeStr("215.07198mm 13.336156mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_Container_1.setPreferredSizeStr("22.438612mm 36.19814mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("192.63336mm 36.19814mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_3.setPreferredSizeStr("215.07198mm 12.7011mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        addComponent(gui_Container);
        gui_BtnSaveChenges.setText("Save Changes");
                gui_BtnSaveChenges.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnSaveChenges.setName("BtnSaveChenges");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnSaveChenges,"\ue161".charAt(0));
        gui_BtnCancel.setText("Cancel");
                gui_BtnCancel.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnCancel.setName("BtnCancel");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnCancel,"\ue5c9".charAt(0));
        gui_Container.addComponent(gui_BtnSaveChenges);
        gui_Container.addComponent(gui_BtnCancel);
        addComponent(gui_Container_1);
        gui_Label.setPreferredSizeStr("22.861982mm inherit");
        gui_Label.setText("Event Name");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:native:MainBold native:MainBold; margin:inherit inherit 3px inherit;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("19.051651mm inherit");
        gui_Label_1.setText("Date");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:native:MainBold native:MainBold; margin:inherit inherit 3px inherit;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("19.051651mm inherit");
        gui_Label_2.setText("Heure");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:native:MainBold native:MainBold; margin:inherit inherit 3px inherit;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setText("Place");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:native:MainBold native:MainBold; margin:inherit inherit 3px inherit;");
        gui_Label_3.setName("Label_3");
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_Label_3);
        addComponent(gui_Container_2);
        gui_event_name.setText("TextField");
                gui_event_name.setInlineStylesTheme(resourceObjectInstance);
        gui_event_name.setInlineAllStyles("font:native:MainBold native:MainBold; border:1.0px solid 0; bgColor:70101; fgColor:0; bgImage:null;");
        gui_event_name.setName("event_name");
        gui_event_name.setColumns(20);
        gui_date.setPreferredSizeStr("74.72481mm inherit");
        gui_date.setText("JJ/MM/AAAA");
                gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setInlineAllStyles("font:native:MainBold native:MainBold; fgColor:90001;");
        gui_date.setName("date");
        gui_date.setType(1);
        gui_heure.setText("00:00");
                gui_heure.setInlineStylesTheme(resourceObjectInstance);
        gui_heure.setInlineAllStyles("font:native:MainBold native:MainBold; fgColor:90001;");
        gui_heure.setName("heure");
        gui_heure.setType(2);
        gui_place.setText("TextField");
                gui_place.setInlineStylesTheme(resourceObjectInstance);
        gui_place.setInlineAllStyles("border:1.0px solid 0; fgColor:70101;");
        gui_place.setName("place");
        gui_Container_2.addComponent(gui_event_name);
        gui_Container_2.addComponent(gui_date);
        gui_Container_2.addComponent(gui_heure);
        gui_Container_2.addComponent(gui_place);
        addComponent(gui_Container_3);
        gui_BtnUpdateMap.setText("Map");
                gui_BtnUpdateMap.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnUpdateMap.setName("BtnUpdateMap");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnUpdateMap,"\ue55b".charAt(0));
        gui_Container_3.addComponent(gui_BtnUpdateMap);
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnUpdateMap.getParent().getLayout()).setInsets(gui_BtnUpdateMap, "auto 10.629921% 2.7519052mm auto").setReferenceComponents(gui_BtnUpdateMap, "-1 -1 -1 -1").setReferencePositions(gui_BtnUpdateMap, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "80.27127% 0.0mm 11.960543% 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "13.316895% auto 65.72133% 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_2, "1 0 1 1 ").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)215.07198);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)12.7011);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 2.5402203mm auto 0.0mm").setReferenceComponents(gui_Container_3, "1 0 -1 -1").setReferencePositions(gui_Container_3, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnSaveChengesActionEvent(com.codename1.ui.events.ActionEvent ev) {
        User u = StaticVars.getCurrentUser();
       
        Event p = new Event(evtupdate.getId(), u.getId(), gui_event_name.getText(), gui_date.getText(), gui_heure.getText(), gui_place.getText());
        System.out.println(gui_place.getText());
        System.out.println(p.getPlace());

        ServiceEvent sp = new ServiceEvent();
        if (sp.updateEvent(p) == 200) {

            Dialog.show("SUCCESS", "Event Updated", "OK", null);

            new ListEvent().show();
        } else {

            Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);
        }
        
        
        
        
        
        
    }

    public void onBtnCancelActionEvent(com.codename1.ui.events.ActionEvent ev) {
        //new ListEvent().show();
        DetailsEvent detevt = new DetailsEvent();
        detevt.gui_event_name.setText(gui_event_name.getText());
        detevt.gui_date.setText(gui_date.getText());
        detevt.gui_heure.setText(gui_heure.getText());
        detevt.gui_place.setText(gui_place.getText());

        detevt.evt = evtupdate;
        
        
        User u = StaticVars.getCurrentUser();
        System.out.println(u.getId()+" "+evtupdate.getIdu());
        if(u.getId()==evtupdate.getIdu()){
           detevt.gui_BtnUpdateEvent.setEnabled(true);
           detevt.gui_BtnDeleteEvent.setEnabled(true);
           detevt.gui_BtnParticipate.setEnabled(false);
        }else{
           detevt.gui_BtnUpdateEvent.setEnabled(false);
           detevt.gui_BtnDeleteEvent.setEnabled(false);
           detevt.gui_BtnParticipate.setEnabled(true);
            
        }
        
        

        detevt.show();

    }

    public void onBtnUpdateMapActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        UpdateEvent upev =new UpdateEvent();
        
        upev.gui_event_name=gui_event_name;
        upev.gui_date=gui_date;
        upev.gui_heure=gui_heure;
        upev.gui_place=gui_place;
        UpdateMap upmap = new UpdateMap();
        upmap.updatemapevent= evtupdate;
        upmap.upevt=upev;
        
        
        List<String> arrSplit = StringUtil.tokenize(upmap.upevt.gui_place.getText(),",");
           Coord lastLocation = new Coord( Double.valueOf(arrSplit.get(0)),Double.valueOf(arrSplit.get(1)));
         
           //Coord lastLocation = new Coord(36.7949999, 10.0732379);
           try { 
            Image i = Image.createImage("/blue_pin.png");
            PointsLayer pl = new PointsLayer();
            pl.setPointIcon(i);
            PointLayer p = new PointLayer(lastLocation,upmap.upevt.gui_event_name.getText(), i);
            
            p.setDisplayName(true);
            pl.addPoint(p);
            upmap.mc.addLayer(pl);
            } catch (IOException ex) {
               System.out.println(ex);
        }
            

            upmap.mc.zoomTo(lastLocation, 16);
            upmap.gui_map.addComponent(upmap.mc);

        
        
        
         upmap.show();
        
    }

}
