package Model;

public abstract class Ingredient extends Modele{

    private int id;
    private String nom;

    public Ingredient(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
