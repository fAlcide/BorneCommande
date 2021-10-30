package Model;

import java.util.ArrayList;

public class Menu extends Modele{

    private int id;
    private Boisson boisson;
    private Plat plat;
    private Accompagnement accompagnement;

    public Menu(Boisson boisson, Plat plat, Accompagnement accompagnement) {
        this.boisson = boisson;
        this.plat = plat;
        this.accompagnement = accompagnement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public void setBoisson(Boisson boisson) {
        this.boisson = boisson;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public Accompagnement getAccompagnement() {
        return accompagnement;
    }

    public void setAccompagnement(Accompagnement accompagnement) {
        this.accompagnement = accompagnement;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "boisson=" + boisson +
                ", plat=" + plat +
                ", accompagnement=" + accompagnement +
                '}';
    }
}
