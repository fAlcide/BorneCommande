package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Commande extends Modele{

    private int id;
    private ArrayList<Menu> menus;
    private ArrayList<Produit> produits;
    private LocalDateTime dateCreation;
    private int etat; // 1 : à préparer; 2 : en cours de préparation; 3 : prête
    private Utilisateur utilisateur;

    public Commande() {
        this.menus = new ArrayList<>();
        this.produits = new ArrayList<>();
        this.dateCreation = LocalDateTime.now();
    }

    public void ajouterMenu(Menu menu){
        this.menus.add(menu);
    }

    public void ajouterProduit(Produit produit){
        this.produits.add(produit);
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

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void afficherContenance() {
        System.out.println("\n\nContenance de la commande #" + this.getId() + " passée le " + this.getDateCreation().getDayOfMonth()  + " " + this.getDateCreation().getMonth()  + " " + this.getDateCreation().getYear() + " à " + this.getDateCreation().getHour() + "h" + this.getDateCreation().getMinute());
        System.out.println("Menus : ");

        int cpt = 0;
        int cptProduit = 0;
        for (Menu menu:this.getMenus()
        ) {
            cpt = cpt + 1;
            System.out.println("Menu" + " - " + cpt + ": " + menu.getPlat().getNom() + ", " + menu.getAccompagnement().getNom() + ", " + menu.getBoisson().getNom());
        }

        System.out.println("");
        System.out.println("Produits : ");

        for (Produit produit:this.getProduits()
        ) {
            cptProduit = cptProduit + 1;
            System.out.println("Produits" + " - " + cptProduit + ": " + produit.getNom());
        }
    }
}
