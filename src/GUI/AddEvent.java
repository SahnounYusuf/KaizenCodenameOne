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
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import entities.Event;
import entities.Participant;
import entities.User;
import services.ServiceEvent;
import services.ServiceParticipant;
import utils.StaticVars;

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

//////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_event_name = new com.codename1.ui.TextField();
    protected com.codename1.ui.spinner.Picker gui_date = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.spinner.Picker gui_heure = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.TextField gui_place = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_ContainerBTN = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_btnAjouter = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btnCancel = new com.codename1.ui.Button();
    protected com.codename1.ui.TextArea gui_Textgeorev = new com.codename1.ui.TextArea();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
        gui_btnAjouter.addActionListener(callback);
        gui_btnCancel.addActionListener(callback);
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
            if(sourceComponent == gui_btnAjouter) {
                onbtnAjouterActionEvent(ev);
            }
            if(sourceComponent == gui_btnCancel) {
                onbtnCancelActionEvent(ev);
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
        gui_Label.setPreferredSizeStr("11.430991mm inherit");
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
        gui_event_name.setInlineAllStyles("border:none; bgColor:98f6f5; fgColor:90001; transparency:188;");
        gui_event_name.setName("event_name");
        gui_date.setPreferredSizeStr("57.154953mm inherit");
        gui_date.setText("28/07/21");
                gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setInlineAllStyles("bgColor:98f6f5; fgColor:30200; transparency:188;");
        gui_date.setName("date");
        gui_date.setType(1);
        gui_heure.setPreferredSizeStr("57.154953mm inherit");
        gui_heure.setText("00:00");
                gui_heure.setInlineStylesTheme(resourceObjectInstance);
        gui_heure.setInlineAllStyles("bgColor:98f6f5; fgColor:10103; transparency:188;");
        gui_heure.setName("heure");
        gui_heure.setType(2);
        gui_place.setEditable(false);
                gui_place.setInlineStylesTheme(resourceObjectInstance);
        gui_place.setInlineAllStyles("border:none; bgColor:98f6f5; fgColor:10100; transparency:188;");
        gui_place.setName("place");
        gui_Button.setText("Map");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineUnselectedStyles("bgColor:7e202; fgColor:ded901; transparency:64;");
        gui_Button.setInlineSelectedStyles("bgColor:1b923; fgColor:fef504;");
        gui_Button.setInlinePressedStyles("bgColor:f19ec; fgColor:e63900; transparency:64;");
        gui_Button.setName("Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button,"\ue55b".charAt(0));
        gui_ContainerBTN.setPreferredSizeStr("84.25063mm 20.321762mm");
                gui_ContainerBTN.setInlineStylesTheme(resourceObjectInstance);
        gui_ContainerBTN.setInlineAllStyles("alignment:center; margin:inherit inherit inherit 20px; padding:20px 20px 20px 20px;");
        gui_ContainerBTN.setName("ContainerBTN");
        gui_Textgeorev.setPreferredSizeStr("50.8044mm 24.978832mm");
        gui_Textgeorev.setEditable(false);
        gui_Textgeorev.setEnabled(false);
        gui_Textgeorev.setText("");
                gui_Textgeorev.setInlineStylesTheme(resourceObjectInstance);
        gui_Textgeorev.setName("Textgeorev");
        gui_Textgeorev.setColumns(8);
        gui_Textgeorev.setRows(2);
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_Label_3);
        addComponent(gui_event_name);
        addComponent(gui_date);
        addComponent(gui_heure);
        addComponent(gui_place);
        addComponent(gui_Button);
        addComponent(gui_ContainerBTN);
        gui_btnAjouter.setPreferredSizeStr("25.613886mm 13.124471mm");
        gui_btnAjouter.setText("Add Event");
                gui_btnAjouter.setInlineStylesTheme(resourceObjectInstance);
        gui_btnAjouter.setName("btnAjouter");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btnAjouter,"\ue145".charAt(0));
        gui_btnCancel.setPreferredSizeStr("19.686707mm 13.124471mm");
        gui_btnCancel.setText("Cancel");
                gui_btnCancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btnCancel.setInlineAllStyles("bgType:none; alignment:right; margin:inherit 30px inherit inherit;");
        gui_btnCancel.setName("btnCancel");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btnCancel,"\ue5c9".charAt(0));
        gui_ContainerBTN.addComponent(gui_btnAjouter);
        gui_ContainerBTN.addComponent(gui_btnCancel);
        addComponent(gui_Textgeorev);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm -1.270112mm 0.0mm 0.0mm").setReferenceComponents(gui_Label, "4 4 4 -1").setReferencePositions(gui_Label, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "17.470882% auto auto 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 0 ").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "28.112217% auto auto 0.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 0 ").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "37.588825% 1.0584259mm auto 0.0mm").setReferenceComponents(gui_Label_3, "-1 4 -1 0 ").setReferencePositions(gui_Label_3, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_event_name.getParent().getLayout()).setInsets(gui_event_name, "8.379175% auto auto 14.370079%").setReferenceComponents(gui_event_name, "-1 -1 -1 -1").setReferencePositions(gui_event_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_date.getParent().getLayout()).setInsets(gui_date, "17.138103% 0.0mm auto 0.0mm").setReferenceComponents(gui_date, "-1 4 -1 4 ").setReferencePositions(gui_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_heure.getParent().getLayout()).setInsets(gui_heure, "28.45258% 0.0mm auto 0.0mm").setReferenceComponents(gui_heure, "-1 4 -1 4 ").setReferencePositions(gui_heure, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_place.getParent().getLayout()).setInsets(gui_place, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_place, "3 -1 3 5 ").setReferencePositions(gui_place, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "auto 4.2337mm 39.70407% auto").setReferenceComponents(gui_Button, "-1 4 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ContainerBTN.getParent().getLayout()).setInsets(gui_ContainerBTN, "72.44389% -7.4505806E-8mm 15.80497% 0.0mm").setReferenceComponents(gui_ContainerBTN, "-1 -1 -1 -1").setReferencePositions(gui_ContainerBTN, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Textgeorev.getParent().getLayout()).setInsets(gui_Textgeorev, "0.0mm -2.1168501mm 4.2337008mm 0.0mm").setReferenceComponents(gui_Textgeorev, "3 4 8 4 ").setReferencePositions(gui_Textgeorev, "0.0 0.0 1.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    
    public void onbtnAjouterActionEvent(com.codename1.ui.events.ActionEvent ev) {
        User u = StaticVars.getCurrentUser();
        
        Event p = new Event(u.getId(),gui_event_name.getText(), gui_date.getText(), gui_heure.getText(), gui_place.getText());
                    ServiceEvent sp = new ServiceEvent();
                    ServiceParticipant serp = new ServiceParticipant();
                    if (sp.addEvent(p) == 200) {
                        
                        Dialog.show("SUCCESS", "Event Added", "OK", null);
                        
                        new ListEvent().show();
                    } else {

                     Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);   
                    }
//     serp.addParticipant(new Participant(p.getId(),u.getId()));             
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
