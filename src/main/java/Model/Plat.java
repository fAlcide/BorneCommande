package Model;

import java.util.ArrayList;

public class Plat extends Produit{

    private int nbPersonne;

    public Plat(int id, String nom, ArrayList<Ingredient> ingredients, float prix, boolean dispoHorsMenu, int nbPersonne) {
        super(id, nom, ingredients, prix, dispoHorsMenu);
        this.nbPersonne = nbPersonne;
    }
}
