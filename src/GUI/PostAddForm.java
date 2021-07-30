/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 * GUI builder created Form
 *
 * @author muhamed
 */
public class PostAddForm extends com.codename1.ui.Form {

    public PostAddForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public PostAddForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
        gui_Text_Field_Post.setUIID("VeloTextField");
    }

//////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.TextField gui_Text_Field_Post = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_BtnBack = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_BtnAddPost = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_BtnBack.addActionListener(callback);
        gui_BtnAddPost.addActionListener(callback);
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

            if(sourceComponent == gui_BtnBack) {
                onBtnBackActionEvent(ev);
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
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("addpost");
        setName("addpost");
        gui_Container.setPreferredSizeStr("189.41798mm 12.962963mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_Container_1.setPreferredSizeStr("189.41798mm 37.56614mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("189.41798mm 10.31746mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        addComponent(gui_Container);
        gui_Label.setText("what's in your mind ? ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Label,"\ue873".charAt(0));
        gui_Container.addComponent(gui_Label);
        addComponent(gui_Container_1);
        gui_Text_Field_Post.setPreferredSizeStr("187.30159mm 35.449738mm");
        gui_Text_Field_Post.setText("Your Postaargfrdh");
                gui_Text_Field_Post.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_Post.setName("Text_Field_Post");
        gui_Container_1.addComponent(gui_Text_Field_Post);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Field_Post.getParent().getLayout()).setInsets(gui_Text_Field_Post, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Text_Field_Post, "-1 -1 -1 -1").setReferencePositions(gui_Text_Field_Post, "0.0 0.0 0.0 0.0");
        addComponent(gui_Container_2);
        gui_BtnBack.setText("Cancel");
                gui_BtnBack.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnBack.setName("BtnBack");
        gui_BtnAddPost.setPreferredSizeStr("inherit 9.259259mm");
        gui_BtnAddPost.setText("Save Post");
                gui_BtnAddPost.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnAddPost.setName("BtnAddPost");
        gui_BtnAddPost.setDisabledIcon(com.codename1.ui.FontImage.createMaterial("\ue145".charAt(0), gui_BtnAddPost.getDisabledStyle()));
        gui_Container_2.addComponent(gui_BtnBack);
        gui_Container_2.addComponent(gui_BtnAddPost);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "2.6455026mm auto 89.09774% 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)189.41798);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)37.56614);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "0 0 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "53.195488% 0.0mm 39.66165% 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 0 ").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onBtnBackActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

    public void onBtnAddPostActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

}
