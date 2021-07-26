/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import entities.Velo;
import services.ServiceVelo;

/**
 *
 * @author bhk
 */
public class veloDisplayForm extends Form {

    /* public  Container BackContainer(){
        Container cnt2 = new Container(BoxLayout.x());

            Button btnBack = new Button("Back");
    btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new addForm().show();
            }
        });
        this.add(btnBack);
        return cnt2;
        
         
     
}*/
    public Container getVeloViewer(Resources res, Velo p) {

        Container cnt = new Container(BoxLayout.x());

        cnt.add(new Label(p.getIdu()));
        cnt.add(new Label(p.getBrand()));
        cnt.add(new Label(p.getModel()));
        cnt.add(new Label(p.getType()));
        cnt.add(new Label(p.getSize()));
        cnt.add(new Label(p.getWheelsize()));
        cnt.add(new Label(p.getBrakingtype()));
        cnt.add(new Label(p.getNumberofspeed()));
        cnt.add(new Label(p.getQuantity()));
        cnt.add(new Label(p.getColor()));
        cnt.add(new Label(p.getWeight()));
        cnt.add(new Label(p.getPrice()));
        cnt.add(new Label(p.getDescription()));

        Button btn = new Button();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("test", "velo avec l'id " + p.getId(), "OK", null);
                new veloUpdateForm(res, p).show();
            }
        });
        cnt.setLeadComponent(btn);
        cnt.getAllStyles().setBorder(Border.createInsetBorder(2));

        return cnt;
    }

    public veloDisplayForm(Resources res) {
        this.getToolbar().addMaterialCommandToLeftBar("",
                FontImage.MATERIAL_ARROW_BACK,
                e -> {
                    new veloAddForm(res).show();
                });
        for (Velo p : new ServiceVelo().getVelos()) {
            this.add(getVeloViewer(res, p));

        }
    }

}
