package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public abstract class Ingredient implements Serializable {

    private int id;
    private String nom;

    public Ingredient(@JsonProperty("id") int id, @JsonProperty("nom") String nom) {
        super();
        this.id = id;
        this.nom = nom;
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
}
