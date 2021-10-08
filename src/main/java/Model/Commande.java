package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Commande extends Modele{

    private int id;
    private ArrayList<Menu> menus;
    private ArrayList<Produit> produits;
    private LocalDateTime dateCreation;

    public Commande() {
        this.id = genererId();
        this.menus = new ArrayList<>();
        this.dateCreation = LocalDateTime.now();
    }

    public int genererId(){
       return 1;
    }

    public void ajouterMenu(Menu menu){
        this.menus.add(menu);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
}
