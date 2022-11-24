/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.gabrielsizilio.sabordecasa.entity;

/**
 * Classe $(Gabriel)
 * @author Gabriel Sizilio <Gabriel at IFNMG>
 */
public class Entity {
    private Long id;
    private boolean excluded;

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExcluded() {
        return excluded;
    }

    public void setExcluded(boolean excluded) {
        this.excluded = excluded;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="toStringo">
    @Override
    public String toString() {
        return "Entity{" + "id=" + id + ", excluded=" + excluded + '}';
    }
//</editor-fold>
    
    
}
