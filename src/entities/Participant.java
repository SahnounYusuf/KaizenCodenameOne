/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Yassine
 */
public class Participant {

    int ide, idu;

    public Participant(int ide, int idu) {
        this.ide = ide;
        this.idu = idu;
    }

    public Participant() {
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    @Override
    public String toString() {
        return "Participant{" + "ide=" + ide + ", idu=" + idu + '}';
    }

}
