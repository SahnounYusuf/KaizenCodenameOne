/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import entities.Piece;
import services.ServicePiece;

/**
 *
 * @author Toshiba
 */
public class PieceDisplayForm extends Form {

    public Container getPieceViewer(Resources res, Piece p) {
        Container cnt = new Container(BoxLayout.x());
        cnt.add(new Label(p.getNom()));
        cnt.add(new Label(p.getType()));
        cnt.add(new Label(p.getDescription()));
        cnt.add(new Label(p.getPrix()));
        Button btn = new Button();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Delet / Modify", "you have choose  " + p.getNom()+" , you can delete or modified it.", "OK", null);
                new PieceUpdateForm(res, p).show();
            }
        });
        cnt.setLeadComponent(btn);
        cnt.getAllStyles().setBorder(Border.createInsetBorder(2));
        return cnt;
    }

    public PieceDisplayForm(Resources res) {
        for (Piece p : new ServicePiece().getPiece()) {
            this.add(getPieceViewer(res, p));
        }
        Button btnBack = new Button("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new PieceAddForm(res).show();
            }
        });
        this.add(btnBack);
    }

}
