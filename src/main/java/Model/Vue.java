package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vue {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Boisson> listeBoissons;
    private ArrayList<Plat> listePlats;
    private ArrayList<Accompagnement> listeAccompagnements;
    private Commande commande = null;
    private Menu menu = null;

    public Vue(ArrayList<Boisson> listeBoissons, ArrayList<Plat> listePlats, ArrayList<Accompagnement> listeAccompagnements) {
        this.listeBoissons = listeBoissons;
        this.listePlats = listePlats;
        this.listeAccompagnements = listeAccompagnements;
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
        System.out.println("0 - Quitter");

        int choix = sc.nextInt();

        while(choix < 0 || choix > 3){
            System.out.println("Entrée invalide");
            choix = sc.nextInt();
        }

        switch(choix){

            case 1:
                choixMenu();
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
    }

    public Menu choixMenu(){
        System.out.flush();
        System.out.println("Selectionner un menu");

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
        System.out.println("Selectionner l'accompagnement de votre menu");

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

    public Boisson choixBoisson(Plat plat, Accompagnement accompagnement){
        System.out.println("Selectionner une boisson pour votre menu");

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
            this.setCommande(new Commande());
            this.commande.ajouterMenu(new Menu( boisson, plat, accompagnement));
            System.out.println("Votre menu a bien été ajouter à votre commande");
            System.out.println(this.commande.toString());
            choixAccueil();
        }
        return null;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
