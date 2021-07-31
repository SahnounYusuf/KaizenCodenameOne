/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.codename1.maps.MapComponent;
import com.codename1.util.StringUtil;

import entities.Event;
import java.util.List;
import services.ServiceEvent;



/**
 * GUI builder created Form
 *
 * @author Yassine
 */
public class UpdateMap extends com.codename1.ui.Form {
    UpdateEvent upevt =new UpdateEvent();
    Event updatemapevent = new Event();
    MapComponent mc = new MapComponent();

    public UpdateMap() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public UpdateMap(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_BtnUpdatePlace = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_map = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.components.ImageViewer gui_Image_Viewer = new com.codename1.components.ImageViewer();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnUpdatePlace.addActionListener(callback);
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

            if(sourceComponent == gui_BtnUpdatePlace) {
                onBtnUpdatePlaceActionEvent(ev);
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
        setTitle("UpdateMap");
        setName("UpdateMap");
        gui_BtnUpdatePlace.setText("Update Place");
                gui_BtnUpdatePlace.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnUpdatePlace.setName("BtnUpdatePlace");
        gui_Container_2.setPreferredSizeStr("111.34631mm 110.49958mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.setPreferredSizeStr("65.41067mm 113.25148mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_BtnUpdatePlace);
        addComponent(gui_Container_2);
        gui_map.setPreferredSizeStr("109.441154mm 153.25995mm");
                gui_map.setInlineStylesTheme(resourceObjectInstance);
        gui_map.setName("map");
        gui_Container_2.addComponent(gui_map);
        ((com.codename1.ui.layouts.LayeredLayout)gui_map.getParent().getLayout()).setInsets(gui_map, "0px 0.0mm 0.0mm 0px").setReferenceComponents(gui_map, "-1 -1 -1 -1").setReferencePositions(gui_map, "0.0 0.0 0.0 0.0");
        addComponent(gui_Container);
        gui_Image_Viewer.setPreferredSizeStr("6.1388655mm 10.795936mm");
                gui_Image_Viewer.setInlineStylesTheme(resourceObjectInstance);
        gui_Image_Viewer.setName("Image_Viewer");
        gui_Image_Viewer.setPropertyValue("imageList", new com.codename1.ui.Image[]{com.codename1.ui.FontImage.createMaterial("\ue55e".charAt(0), new com.codename1.ui.plaf.Style())});
        gui_Container.addComponent(gui_Image_Viewer);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Image_Viewer.getParent().getLayout()).setInsets(gui_Image_Viewer, "auto 45.33762% 46.16823% 44.051445%").setReferenceComponents(gui_Image_Viewer, "-1 -1 -1 -1").setReferencePositions(gui_Image_Viewer, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnUpdatePlace.getParent().getLayout()).setInsets(gui_BtnUpdatePlace, "auto 7.490637% 6.1388655mm auto").setReferenceComponents(gui_BtnUpdatePlace, "-1 -1 -1 -1").setReferencePositions(gui_BtnUpdatePlace, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)65.19898);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)110.49958);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0px 0px 1.6934801mm 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 0 -1").setReferencePositions(gui_Container_2, "0.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)65.41067);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)113.25148);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 1.058425mm").setReferenceComponents(gui_Container, "-1 -1 0 1 ").setReferencePositions(gui_Container, "0.0 0.0 1.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnUpdatePlaceActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        //System.out.println(ReverseGeoCoding(String.valueOf(mc.getCenter().getLatitude()),String.valueOf(mc.getCenter().getLongitude())));
        UpdateEvent upevent = new UpdateEvent();
        upevent.gui_place.setText(mc.getCenter().getLatitude()+","+mc.getCenter().getLongitude());
        upevent.gui_event_name.setText(upevt.gui_event_name.getText());
        upevent.gui_date.setText(upevt.gui_date.getText());
        upevent.gui_heure.setText(upevt.gui_heure.getText());
        upevent.evtupdate=updatemapevent;
        upevent.gui_place.setHidden(true);
        List<String> st =StringUtil.tokenize(mc.getCenter().getLatitude()+","+mc.getCenter().getLongitude(),",");
        upevent.gui_Textgeorev.setText(new ServiceEvent().getAdress(st.get(0),st.get(1)));
             
        upevent.showBack();
        
    }
    
//    public String ReverseGeoCoding (String lat, String lon){
//
//        String url = "https://nominatim.openstreetmap.org/reverse?format=xml&lat="+lat+"&lon="+lon+"&zoom=18&addressdetails=1";   
//    try
//    {
//        DocumentBuilderFactory f = 
//                DocumentBuilderFactory.newInstance();
//        DocumentBuilder b = f.newDocumentBuilder();
//        Document doc = b.parse(url);
//
//        doc.getDocumentElement().normalize();
//        System.out.println ("Root element: " + 
//                    doc.getDocumentElement().getNodeName());
//
//    }
//    catch (Exception e)
//    {
//        e.printStackTrace();
//    }
//        
//        return "";
//    }
    
    

}
