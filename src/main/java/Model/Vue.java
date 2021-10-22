package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vue {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Boisson> listeBoissons;
    private ArrayList<Plat> listePlats;
    private ArrayList<Accompagnement> listeAccompagnements;
    ArrayList<Produit> listeProduits = new ArrayList<>();
    private Commande commande = null;

    public Vue(ArrayList<Boisson> listeBoissons, ArrayList<Plat> listePlats, ArrayList<Accompagnement> listeAccompagnements) {
        this.listeBoissons = listeBoissons;
        this.listePlats = listePlats;
        this.listeAccompagnements = listeAccompagnements;
        this.listeProduits.addAll(this.listePlats);
        this.listeProduits.addAll(this.listeAccompagnements);
        this.listeProduits.addAll(this.listeBoissons);
    }

    public int choixAccueil(){
        System.out.println("1 - Passer une commande");
        System.out.println("2 - Mes commandes");
        System.out.println("0 - Quitter");


        int choix = sc.nextInt();

        while(choix < 0 || choix > 2){
            System.out.println("Entrée invalide");
            choix = sc.nextInt();
        }

        switch(choix){

            case 1:
                commande();
                break;

            case 2:
                System.out.println("Hello");
                break;

            case 3:
                System.out.println("Buenos dias");
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }

        return choix;
    }

    public void commande(){
        System.out.println("1 - Menus");
        System.out.println("2 - Produits");
        System.out.println("3 - Contenance de la commande");
        System.out.println("4 - Valider la commande");
        System.out.println("0 - Annuler la commande");

        int choix = sc.nextInt();

        while(choix < 0 || choix > 3){
            System.out.println("Entrée invalide");
            choix = sc.nextInt();
        }

        switch(choix){

            case 0:
                annulerCommande();
                break;

            case 1:
                choixMenu();
                break;

            case 2:
                choixProduit();
                break;

            case 3:
                contenanceCommande();
                break;

            case 4:
                System.out.println("Buenos dias");
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }
    }

    public Menu choixMenu(){
        System.out.flush();
        System.out.println("Selectionnez le plat de votre menu");

        int cpt = 0;
        for (Plat plats:listePlats
             ) {
            cpt = cpt + 1;
            System.out.println(cpt + " - " + plats.getNom());
        }

        System.out.println("0 - Quitter");
        int choix = sc.nextInt();
        while(choix < 0 || choix > listePlats.size()){
            choix = sc.nextInt();
        }

        if(choix != 0){
            choixAccompagnement(listePlats.get(cpt - 1));
        }

        return null;
    }

    public void choixAccompagnement(Plat plat){
        System.out.println("Selectionnez l'accompagnement de votre menu");

        int cpt = 0;
        for (Accompagnement accompagnement:listeAccompagnements
        ) {
            cpt = cpt + 1;
            System.out.println(cpt + " - " + accompagnement.getNom());
        }

        System.out.println("0 - Quitter");
        int choix = sc.nextInt();
        while(choix < 0 || choix > listeAccompagnements.size()){
            choix = sc.nextInt();
        }
        if(choix != 0){
            choixBoisson(plat, listeAccompagnements.get(choix - 1));
        }
    }

    public void choixBoisson(Plat plat, Accompagnement accompagnement){
        System.out.println("Selectionnez une boisson pour votre menu");

        int cpt = 0;
        for (Boisson boisson:listeBoissons
        ) {
            cpt = cpt + 1;
            System.out.println(cpt + " - " + boisson.getNom());
        }

        System.out.println("0 - Quitter");
        int choix = sc.nextInt();
        while(choix < 0 || choix > listeBoissons.size()){
            choix = sc.nextInt();
        }
        if(choix != 0){
            Boisson boisson =  listeBoissons.get(choix - 1);
            if(this.getCommande() == null){
                this.setCommande(new Commande());
            }
            this.commande.ajouterMenu(new Menu( boisson, plat, accompagnement));
            System.out.println("Votre menu a bien été ajouté à votre commande");
            commande();
        }
    }

    public void choixProduit(){
        System.out.println("Selectionnez un produit à ajouter à votre commande");

        int cpt = 0;
        for (Produit produit:listeProduits
        ) {
            cpt = cpt + 1;
            System.out.println(cpt + " - " + produit.getNom());
        }

        System.out.println("0 - Quitter");
        int choix = sc.nextInt();
        while(choix < 0 || choix > listeProduits.size()){
            choix = sc.nextInt();
        }
        if(choix != 0){
            Produit produit =  listeProduits.get(choix - 1);
            if(this.getCommande() == null){
                this.setCommande(new Commande());
            }
            this.commande.ajouterProduit(produit);
            System.out.println(produit.getNom() + " a bien été ajouté à votre commande");
            commande();
        }
    }

    public void contenanceCommande(){
        System.out.println("Contenance de la commande");
        System.out.println("Menus : ");

        int cpt = 0;
        int cptProduit = 0;
        for (Menu menu:this.commande.getMenus()
        ) {
            cpt = cpt + 1;
            System.out.println("Menu" + " - " + cpt + ": " + menu.getPlat().getNom() + ", " + menu.getAccompagnement().getNom() + ", " + menu.getBoisson().getNom());
        }

        System.out.println("");
        System.out.println("Produits");

        for (Produit produit:this.commande.getProduits()
        ) {
            cptProduit = cptProduit + 1;
            System.out.println("Produits" + " - " + cptProduit + ": " + produit.getNom());
        }

        System.out.println("0 - Retour");
        int choix = sc.nextInt();
        while(choix < 0 || choix > listeProduits.size()){
            choix = sc.nextInt();
        }

        if(choix == 0){
            commande();
        }
    }

    public void annulerCommande(){
        this.setCommande(null);
        choixMenu();
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
