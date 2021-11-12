package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vue {

    private static Vue instance;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Boisson> listeBoissons;
    private ArrayList<Plat> listePlats;
    private ArrayList<Accompagnement> listeAccompagnements;
    private ArrayList<Produit> listeProduits = new ArrayList<>();
    private Commande commande = null;
    private FileManager fileManager;
    private Utilisateur user;


    private Vue(ArrayList<Boisson> listeBoissons, ArrayList<Plat> listePlats, ArrayList<Accompagnement> listeAccompagnements, FileManager fileManager) {
        this.listeBoissons = listeBoissons;
        this.listePlats = listePlats;
        this.listeAccompagnements = listeAccompagnements;
        this.listeProduits.addAll(this.listePlats);
        this.listeProduits.addAll(this.listeAccompagnements);
        this.listeProduits.addAll(this.listeBoissons);
        this.fileManager = fileManager;
    }

    public static Vue getInstance(ArrayList<Boisson> listeBoissons, ArrayList<Plat> listePlats, ArrayList<Accompagnement> listeAccompagnements, FileManager fileManager){
        if(instance == null){
            return new Vue(listeBoissons, listePlats, listeAccompagnements, fileManager);
        }else{
            return instance;
        }
    }

    // Indentification du client
    public boolean identification() throws IOException, ClassNotFoundException {
        System.out.println("" +
                "██████╗ ██╗███████╗███╗   ██╗██╗   ██╗███████╗███╗   ██╗██╗   ██╗███████╗     █████╗ ██╗   ██╗\n" +
                "██╔══██╗██║██╔════╝████╗  ██║██║   ██║██╔════╝████╗  ██║██║   ██║██╔════╝    ██╔══██╗██║   ██║\n" +
                "██████╔╝██║█████╗  ██╔██╗ ██║██║   ██║█████╗  ██╔██╗ ██║██║   ██║█████╗      ███████║██║   ██║\n" +
                "██╔══██╗██║██╔══╝  ██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║   ██║██╔══╝      ██╔══██║██║   ██║\n" +
                "██████╔╝██║███████╗██║ ╚████║ ╚████╔╝ ███████╗██║ ╚████║╚██████╔╝███████╗    ██║  ██║╚██████╔╝\n" +
                "╚═════╝ ╚═╝╚══════╝╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝ ╚═════╝ ╚══════╝    ╚═╝  ╚═╝ ╚═════╝ \n" +
                "                                                                                              \n");
        System.out.println(
                "███████╗ █████╗ ███████╗████████╗    ███████╗ ██████╗  ██████╗ ██████╗      ██████╗ ████████╗\n" +
                "██╔════╝██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔═══██╗██╔═══██╗██╔══██╗    ██╔═══██╗╚══██╔══╝\n" +
                "█████╗  ███████║███████╗   ██║       █████╗  ██║   ██║██║   ██║██║  ██║    ██║   ██║   ██║   \n" +
                "██╔══╝  ██╔══██║╚════██║   ██║       ██╔══╝  ██║   ██║██║   ██║██║  ██║    ██║▄▄ ██║   ██║   \n" +
                "██║     ██║  ██║███████║   ██║       ██║     ╚██████╔╝╚██████╔╝██████╔╝    ╚██████╔╝   ██║   \n" +
                "╚═╝     ╚═╝  ╚═╝╚══════╝   ╚═╝       ╚═╝      ╚═════╝  ╚═════╝ ╚═════╝      ╚══▀▀═╝    ╚═╝   \n" +
                "                                                                                             \n");

        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< IDENTIFICATION >><<>><<>><<>><<>><<>><<>><<>>\n");
        System.out.println("1 - S'identifier");
        System.out.println("2 - Créer un compte");

        int choix = sc.nextInt();

        if(choix == 1){
            String pos = sc.nextLine(); // Permet de casser le \n du scanner int juste avant
            System.out.println("Entrez votre id utilisateur :");
            String id = sc.nextLine();
            Utilisateur userFromId = fileManager.getUserByIdFromFile(id); // Récupère l'utilisateur
            if(userFromId != null){ // S'il existe
                this.setUser(userFromId); // Il est instancié
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                return true;
            }else{
                System.out.println("Utilisateur inconnu"); // Sinon on notifie le client que l'id fourni est inconnu
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                return false;
            }
        }
        // Création d'un compte client
        else if(choix == 2){
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><< CREATION COMPTE >><<>><<>><<>><<>><<>><<>><<>>");
            String pos = sc.nextLine(); // Permet de casser le \n du scanner int juste avant
            System.out.println("\nVoici votre id, il vous permettra de vous connecter à la borne, gardez le précieusement\n");
            String id = fileManager.getNewId(); // Demande un nouvel il qui n'existe pas au file manager
            System.out.println("Votre id est " + id + ". Gardez le préciseusement.\n");
            System.out.println("Entrez votre nom :");
            String nom = sc.nextLine(); // Le client rentre son nom
            Utilisateur user = new Utilisateur(id, nom); // on crée l'utilisateur
            fileManager.addUserToFile(user); // Ajoute en base de données
            this.setUser(user); // Set sur la borne l'utilisateur
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            return true;
        }
        return false;
    }

    // Menu acceuil
    public int choixAccueil() throws IOException, ClassNotFoundException, InterruptedException {
        if(!identification()){
            return 0;
        }
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< BIENVENUE " + this.user.getNom() + " >><<>><<>><<>><<>><<>><<>><<>>\n");
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
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;
            case 2:
                afficherCommandesUtilisateur();
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;
            case 0:
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                return 0;
            default:
                System.out.println("Choix incorrect");
                break;
        }

        return choix;
    }

    // Menu pour passer une commande
    public void commande() throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< MENU COMMANDE >><<>><<>><<>><<>><<>><<>><<>>\n");

        System.out.println("1 - Menus");
        System.out.println("2 - Produits");
        System.out.println("3 - Contenance de la commande");
        System.out.println("4 - Valider la commande");
        System.out.println("0 - Annuler la commande");

        int choix = sc.nextInt();

        while(choix < 0 || choix > 4){
            System.out.println("Entrée invalide");
            choix = sc.nextInt();
        }

        switch(choix){
            case 0:
                choixAccueil();
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;
            case 1:
                choixMenu();
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;

            case 2:
                choixProduit();
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;

            case 3:
                contenanceCommande();
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;
            case 4:
                validationCommande();
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }

    }

    // Menu pour choisir le menu
    public Menu choixMenu() throws IOException, ClassNotFoundException, InterruptedException {
            System.out.flush();
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><< CHOIX DU MENU >><<>><<>><<>><<>><<>><<>><<>>\n");

            int cpt = 0;
            for (Plat plats : listePlats
            ) {
                cpt = cpt + 1;
                System.out.println(cpt + " - Menu " + plats.getNom() + " " + plats.getIngredientToString() +  " avec des frites et une boisson au choix.  " + plats.getPrixMenu() + "€\n");
            }

            System.out.println("0 - Quitter");
            int choix = sc.nextInt();
            while (choix < 0 || choix > listePlats.size()) {
                choix = sc.nextInt();
            }

            if(choix == 0){
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                commande();
            }else{
                System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
                choixAccompagnement(listePlats.get(choix - 1));
            }

        return null;
    }

    // Menu pour choisir son accompagnement
    public void choixAccompagnement(Plat plat) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< CHOIX DE L'ACCOMPAGNEMENT >><<>><<>><<>><<>><<>><<>><<>>\n");

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
        if(choix == 0){
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            commande();
        }else{
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            choixBoisson(plat, listeAccompagnements.get(choix - 1));
        }
    }

    // Menu pour choisir sa boisson
    public void choixBoisson(Plat plat, Accompagnement accompagnement) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< CHOIX DE LA BOISSON >><<>><<>><<>><<>><<>><<>><<>>\n");

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
        if(choix == 0){
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            commande();
        }else{
            Boisson boisson =  listeBoissons.get(choix - 1);
            if(this.getCommande() == null){
                this.setCommande(new Commande());
            }
            this.commande.ajouterMenu(new Menu( boisson, plat, accompagnement));
            System.out.println("->->->->->-> Votre menu a bien été ajouté à votre commande\n");
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            commande();
        }
    }

    // Menu pour chosir des produits hors menu
    public void choixProduit() throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< CHOIX DU PRODUIT >><<>><<>><<>><<>><<>><<>><<>>\n");

        int cpt = 0;
        for (Produit produit:listeProduits
        ) {
            cpt = cpt + 1;
            System.out.println(cpt + " - " + produit.getNom() + " " + produit.getPrix() + "€");
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
            System.out.println("->->->->->-> " + produit.getNom() + " a bien été ajouté à votre commande");
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            commande();
        }
    }

    // Afficher la contenance de sa commande
    public void contenanceCommande() throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><< CONTENANCE DE LA COMMANDE >><<>><<>><<>><<>><<>><<>><<>>\n");
        System.out.println("Menus : ");

        int cpt = 0;
        int cptProduit = 0;
        for (Menu menu:this.commande.getMenus()
        ) {
            cpt = cpt + 1;
            System.out.println("Menu" + " - " + cpt + ": " + menu.getPlat().getNom() + ", " + menu.getAccompagnement().getNom() + ", " + menu.getBoisson().getNom());
        }

        System.out.println("");
        System.out.println("Produits :");

        for (Produit produit:this.commande.getProduits()
        ) {
            cptProduit = cptProduit + 1;
            System.out.println("Produits" + " - " + cptProduit + ": " + produit.getNom());
        }

        System.out.println("\nPrix total de la commande : " + this.getCommande().getPrixCommande() + "€\n");

        System.out.println("0 - Retour");
        int choix = sc.nextInt();
        while(choix < 0 || choix > listeProduits.size()){
            choix = sc.nextInt();
        }

        if(choix == 0){
            System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>\n");
            commande();
        }
    }

    // Validation de la commande
    public void validationCommande() throws IOException, ClassNotFoundException, InterruptedException {
        this.commande.setId(fileManager.generationIdCommande());
        this.commande.setUtilisateur(this.user);
        this.commande.setEtat(1);
        fileManager.addCommandeToFile(this.commande);
        System.out.println("Merci d'avoir passé commande chez nous !");
        System.out.println("Votre numéro de commande est le " + this.commande.getId());
        this.commande = null;
        Thread.sleep(3000);
    }

    public void annulerCommande() throws IOException, ClassNotFoundException, InterruptedException {
        this.setCommande(null);
        System.out.println("Commande annulée");
        choixMenu();
    }

    // Afficher les commandes de l'utilisateur
    public void afficherCommandesUtilisateur() throws IOException, ClassNotFoundException {
        ArrayList<Commande> commandes = fileManager.getAllCommandesByIdUser(user);
        for (Commande c: commandes
             ) {
            c.afficherContenance();
        }
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getUser() {
        return user;
    }
}
