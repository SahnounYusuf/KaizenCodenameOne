/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Dialog;
import entities.Event;
import services.ServiceEvent;

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
        gui_heure.setUIID("VeloTextField");
        gui_date.setUIID("VeloTextField");
    }

//////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_event_name = new com.codename1.ui.TextField();
    protected com.codename1.ui.spinner.Picker gui_date = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.spinner.Picker gui_heure = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.TextField gui_place = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_BtnSaveChenges = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnCancel = new com.codename1.ui.Button();

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnSaveChenges.addActionListener(callback);
        gui_BtnCancel.addActionListener(callback);
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

            if (sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if (sourceComponent == gui_BtnSaveChenges) {
                onBtnSaveChengesActionEvent(ev);
            }
            if (sourceComponent == gui_BtnCancel) {
                onBtnCancelActionEvent(ev);
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
        gui_Label.setPreferredSizeStr("22.861982mm inherit");
        gui_Label.setText("Event Name");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("19.051651mm inherit");
        gui_Label_1.setText("Date");
        gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("19.051651mm inherit");
        gui_Label_2.setText("Heure");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_Label_3.setText("Place");
        gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_event_name.setText("TextField");
        gui_event_name.setInlineStylesTheme(resourceObjectInstance);
        gui_event_name.setInlineAllStyles("border:1.0px solid 0; bgColor:70101; fgColor:0; transparency:14; bgImage:null;");
        gui_event_name.setName("event_name");
        gui_date.setPreferredSizeStr("57.154953mm inherit");
        gui_date.setText("...");
        gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setName("date");
        gui_date.setType(1);
        gui_heure.setPreferredSizeStr("57.79001mm inherit");
        gui_heure.setText("00:00");
        gui_heure.setInlineStylesTheme(resourceObjectInstance);
        gui_heure.setName("heure");
        gui_heure.setType(2);
        gui_place.setText("TextField");
        gui_place.setInlineStylesTheme(resourceObjectInstance);
        gui_place.setInlineAllStyles("border:1.0px solid 0; fgColor:70101;");
        gui_place.setName("place");
        gui_BtnSaveChenges.setText("Save Changes");
        gui_BtnSaveChenges.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnSaveChenges.setName("BtnSaveChenges");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnSaveChenges, "\ue161".charAt(0));
        gui_BtnCancel.setText("Cancel");
        gui_BtnCancel.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnCancel.setName("BtnCancel");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BtnCancel, "\ue5c9".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_Label_3);
        addComponent(gui_event_name);
        addComponent(gui_date);
        addComponent(gui_heure);
        addComponent(gui_place);
        addComponent(gui_BtnSaveChenges);
        addComponent(gui_BtnCancel);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Label, "4 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "5 -1 5 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "5.715493mm auto auto 0.0mm").setReferenceComponents(gui_Label_2, "1 3 -1 0 ").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "32.94509% auto auto 0.0mm").setReferenceComponents(gui_Label_3, "-1 -1 -1 1 ").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_event_name.getParent().getLayout()).setInsets(gui_event_name, "8.818636% auto auto 23.934837%").setReferenceComponents(gui_event_name, "-1 -1 -1 -1").setReferencePositions(gui_event_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_date.getParent().getLayout()).setInsets(gui_date, "16.638935% 0.0mm auto 0.0mm").setReferenceComponents(gui_date, "-1 4 -1 4 ").setReferencePositions(gui_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_heure.getParent().getLayout()).setInsets(gui_heure, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_heure, "2 7 3 4 ").setReferencePositions(gui_heure, "0.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_place.getParent().getLayout()).setInsets(gui_place, "32.7787% auto auto 24.310778%").setReferenceComponents(gui_place, "-1 -1 -1 -1").setReferencePositions(gui_place, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_BtnSaveChenges.getParent().getLayout()).setInsets(gui_BtnSaveChenges, "auto auto 20.508976% 2.1168518mm").setReferenceComponents(gui_BtnSaveChenges, "-1 -1 -1 0 ").setReferencePositions(gui_BtnSaveChenges, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_BtnCancel.getParent().getLayout()).setInsets(gui_BtnCancel, "0.0mm -1.9051647mm auto 77.10145%").setReferenceComponents(gui_BtnCancel, "8 6 8 -1").setReferencePositions(gui_BtnCancel, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnSaveChengesActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Event p = new Event(evtupdate.getId(), 3, gui_event_name.getText(), gui_date.getText(), gui_heure.getText(), gui_place.getText());
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

        detevt.show();

    }

}
