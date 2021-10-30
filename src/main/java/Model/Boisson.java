package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Boisson extends Produit implements Serializable {

    private int contenance;

    public Boisson(@JsonProperty("id") int id, @JsonProperty("nom") String nom, @JsonProperty("ingredients") ArrayList<Ingredient> ingredients, @JsonProperty("prix") float prix, @JsonProperty("dispoHorsMenu") boolean dispoHorsMenu, @JsonProperty("contenance") int contenance) {
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
