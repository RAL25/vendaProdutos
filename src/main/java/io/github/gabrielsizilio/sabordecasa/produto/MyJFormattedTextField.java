/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.produto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFormattedTextField;

/**
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class MyJFormattedTextField extends JFormattedTextField{
    private Color corFoco;

    public MyJFormattedTextField() {
        this(new Color(255,255,255), new Color(255,255,176));
    }

    public MyJFormattedTextField(Color corPadrao, Color corFoco) {
        this.corFoco = corFoco;
        addFocusListener(new FocusHandler());
    }
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public Color getCorFoco() {
        return corFoco;
    }

    public void setCorFoco(Color corFoco) {
        this.corFoco = corFoco;
    }
//</editor-fold>
    
    
    class FocusHandler implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            selectAll();
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }
}
