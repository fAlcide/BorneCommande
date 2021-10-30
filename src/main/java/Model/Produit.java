package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public abstract class Produit extends Modele{

    private int id;
    private String nom;
    private ArrayList<Ingredient> ingredients;
    private float prix;
    private boolean dispoHorsMenu;

    public Produit() {
    }

    public Produit(int id, String nom, ArrayList<Ingredient> ingredients, float prix, boolean dispoHorsMenu) {
        this.id = id;
        this.nom = nom;
        this.ingredients = ingredients;
        this.prix = prix;
        this.dispoHorsMenu = dispoHorsMenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isDispoHorsMenu() {
        return dispoHorsMenu;
    }

    public void setDispoHorsMenu(boolean dispoHorsMenu) {
        this.dispoHorsMenu = dispoHorsMenu;
    }


}
