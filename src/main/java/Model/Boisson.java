package Model;

import java.util.ArrayList;

public class Boisson extends Produit{

    private int contenance;

    public Boisson(int id, String nom, ArrayList<Ingredient> ingredients, float prix, boolean dispoHorsMenu, int contenance) {
        super(id, nom, ingredients, prix, dispoHorsMenu);
        this.contenance = contenance;
    }

    public int getContenance() {
        return contenance;
    }

    public void setContenance(int contenance) {
        this.contenance = contenance;
    }
}
