/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import com.codename1.maps.Coord;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import entities.Event;
import services.ServiceEvent;

/**
 * GUI builder created Form
 *
 * @author Yassine
 */
public class AddEvent extends com.codename1.ui.Form {

    public AddEvent() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AddEvent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_event_name = new com.codename1.ui.TextField();
    protected com.codename1.ui.spinner.Picker gui_date = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.spinner.Picker gui_heure = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.Button gui_btnAjouter = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btnCancel = new com.codename1.ui.Button();
    protected com.codename1.ui.TextField gui_place = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btnAjouter.addActionListener(callback);
        gui_btnCancel.addActionListener(callback);
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

            if(sourceComponent == gui_btnAjouter) {
                onbtnAjouterActionEvent(ev);
            }
            if(sourceComponent == gui_btnCancel) {
                onbtnCancelActionEvent(ev);
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
        setTitle("Add Event");
        setName("AddEvent");
        gui_Label.setPreferredSizeStr("34.92803mm inherit");
        gui_Label.setText("Event Name");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("fgColor:70101;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("29.847588mm inherit");
        gui_Label_1.setText("Date");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("fgColor:70101;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("35.77477mm inherit");
        gui_Label_2.setText("Heure");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("fgColor:70101;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("19.051651mm inherit");
        gui_Label_3.setText("Place");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("fgColor:70101;");
        gui_Label_3.setName("Label_3");
                gui_event_name.setInlineStylesTheme(resourceObjectInstance);
        gui_event_name.setInlineAllStyles("border:1.0px solid 0;");
        gui_event_name.setName("event_name");
        gui_date.setPreferredSizeStr("57.154953mm inherit");
        gui_date.setText("...");
                gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setName("date");
        gui_date.setType(1);
        gui_heure.setPreferredSizeStr("57.154953mm inherit");
        gui_heure.setText("00:00");
                gui_heure.setInlineStylesTheme(resourceObjectInstance);
        gui_heure.setName("heure");
        gui_heure.setType(2);
        gui_btnAjouter.setPreferredSizeStr("26.037256mm 11.007621mm");
        gui_btnAjouter.setText("Add Event");
                gui_btnAjouter.setInlineStylesTheme(resourceObjectInstance);
        gui_btnAjouter.setInlineAllStyles("alignment:left;");
        gui_btnAjouter.setName("btnAjouter");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btnAjouter,"\ue145".charAt(0));
        gui_btnCancel.setPreferredSizeStr("19.686707mm 11.007621mm");
        gui_btnCancel.setText("Cancel");
                gui_btnCancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btnCancel.setInlineAllStyles("alignment:right;");
        gui_btnCancel.setName("btnCancel");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btnCancel,"\ue5c9".charAt(0));
                gui_place.setInlineStylesTheme(resourceObjectInstance);
        gui_place.setInlineAllStyles("border:1.0px solid 0;");
        gui_place.setName("place");
        gui_Button.setText("Map");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineUnselectedStyles("bgColor:7e202; fgColor:ded901; transparency:64;");
        gui_Button.setInlineSelectedStyles("bgColor:1b923; fgColor:fef504;");
        gui_Button.setInlinePressedStyles("bgColor:f19ec; fgColor:e63900; transparency:64;");
        gui_Button.setName("Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button,"\ue55b".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_Label_3);
        addComponent(gui_event_name);
        addComponent(gui_date);
        addComponent(gui_heure);
        addComponent(gui_btnAjouter);
        addComponent(gui_btnCancel);
        addComponent(gui_place);
        addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 9.314138mm 0.0mm 0.0mm").setReferenceComponents(gui_Label, "4 4 4 -1").setReferencePositions(gui_Label, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "17.470882% auto auto 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 0 ").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "28.112217% auto auto 0.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 0 ").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "37.588825% 1.0584259mm auto 0.0mm").setReferenceComponents(gui_Label_3, "-1 4 -1 0 ").setReferencePositions(gui_Label_3, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_event_name.getParent().getLayout()).setInsets(gui_event_name, "8.63132% auto auto 13.208465%").setReferenceComponents(gui_event_name, "-1 -1 -1 -1").setReferencePositions(gui_event_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_date.getParent().getLayout()).setInsets(gui_date, "17.138103% 0.0mm auto 0.0mm").setReferenceComponents(gui_date, "-1 4 -1 4 ").setReferencePositions(gui_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_heure.getParent().getLayout()).setInsets(gui_heure, "28.45258% 0.0mm auto 0.0mm").setReferenceComponents(gui_heure, "-1 4 -1 4 ").setReferencePositions(gui_heure, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btnAjouter.getParent().getLayout()).setInsets(gui_btnAjouter, "auto 0.0mm 13.893717% 1.6934801mm").setReferenceComponents(gui_btnAjouter, "-1 4 -1 0 ").setReferencePositions(gui_btnAjouter, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btnCancel.getParent().getLayout()).setInsets(gui_btnCancel, "0.0mm 1.4817944mm auto 0.0mm").setReferenceComponents(gui_btnCancel, "7 4 7 10 ").setReferencePositions(gui_btnCancel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_place.getParent().getLayout()).setInsets(gui_place, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_place, "3 -1 3 5 ").setReferencePositions(gui_place, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "46.03999% 5.5038104mm auto auto").setReferenceComponents(gui_Button, "-1 4 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    
    public void onbtnAjouterActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Event p = new Event(gui_event_name.getText(), gui_date.getText(), gui_heure.getText(), gui_place.getText());
                    ServiceEvent sp = new ServiceEvent();
                    if (sp.addEvent(p) == 200) {

                        Dialog.show("SUCCESS", "Event Added", "OK", null);
                        
                        new ListEvent().show();
                    } else {

                     Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);   
                    }
                  
    }
    
 

    public void onbtnCancelActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        new ListEvent().show();
    }

    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        AddEvent addevt =new AddEvent();
        addevt.gui_event_name=gui_event_name;
        addevt.gui_date=gui_date;
        addevt.gui_heure=gui_heure;
        addevt.gui_place=gui_place;
        
        AddMap map =new AddMap();
        map.addevt=addevt;
        map.show();
    }

}
