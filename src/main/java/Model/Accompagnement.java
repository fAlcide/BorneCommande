package Model;

import java.util.ArrayList;

public class Accompagnement extends Produit{

    private int nbPortions;

    public Accompagnement(int id, String nom, ArrayList<Ingredient> ingredients, float prix, boolean dispoHorsMenu, int nbPortions) {
        super(id, nom, ingredients, prix, dispoHorsMenu);
        this.nbPortions = nbPortions;
    }
}
