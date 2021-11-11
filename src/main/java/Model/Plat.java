package Model;

import java.util.ArrayList;

public class Plat extends Produit{

    private int nbPersonne;

    public Plat(int id, String nom, ArrayList<Ingredient> ingredients, float prix, boolean dispoHorsMenu, int nbPersonne) {
        super(id, nom, ingredients, prix, dispoHorsMenu);
        this.nbPersonne = nbPersonne;
    }

    public double getPrixMenu(){
        return this.getPrix() + 1.50;
    }

    public String getIngredientToString(){
        String ingredients = "(";
        for (Ingredient ingredient: this.getIngredients()
             ) {
            ingredients = ingredients + ingredient.getNom() + ",";
        }

        ingredients = ingredients.substring(0, ingredients.length() - 1);
        ingredients = ingredients + ")";

        return ingredients;
    }
}
