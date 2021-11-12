package Model;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Cuisine extends Thread{

    private String nom;
    private Commande commande;
    private FileManager fileManager;
    private FenetreCommande fenetre;

    public Cuisine(){
    }

    public Cuisine(String nom, FenetreCommande fenetreCommande, FileManager fileManager){
        this.nom = nom;
        this.fenetre = fenetreCommande;
        this.fileManager = fileManager;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void run(){
        while(true){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setCommande(fileManager.getCommandeToCook());
            if(commande != null) {
                this.commande.setEtat(2);
                try {
                    fileManager.addCommandeToFile(this.commande);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                int tempsPreparation = 0;

                //Récupération dse temps de cuisson des menus
                for (Menu menu :
                        this.getCommande().getMenus()) {
                    // Récupération du temps de cuisson total des ingrédients pour les plats des menus
                    for (Ingredient ingredient :
                            menu.getPlat().getIngredients()) {
                        if(ingredient instanceof IngredientAvecCuisson) {
                            tempsPreparation = tempsPreparation + ((IngredientAvecCuisson) ingredient).getTempsCuisson();
                        }
                    }

                    // Récupération du temps de cuisson total des accompagnements pour les produits des menus
                    for (Ingredient ingredient :
                            menu.getAccompagnement().getIngredients()) {
                        if(ingredient instanceof IngredientAvecCuisson) {
                            tempsPreparation = tempsPreparation + ((IngredientAvecCuisson) ingredient).getTempsCuisson();
                        }
                    }
                }

                // Récupération des temps de cuissons des produits hors menu
                for (Produit produit :
                        this.getCommande().getProduits()) {
                    // Récupération du temps de cuisson total des ingrédients
                    for (Ingredient ingredient :
                            produit.getIngredients()) {
                        if(ingredient instanceof IngredientAvecCuisson) {
                            tempsPreparation = tempsPreparation + ((IngredientAvecCuisson) ingredient).getTempsCuisson();
                        }
                    }
                }
                fenetre.ajouterLabel("\n" +
                        "\n" +
                        "Commande n• " + this.getCommande().getId() + " en cours de préparation. Temps d'attente estimé : " + tempsPreparation + " secondes\n" +
                        "\n"
                );

                try {
                    for (int i = 0; i < 2; i ++){
                        sleep(tempsPreparation / 2 * 1000);
                        if(i == 0) {
                            fenetre.ajouterLabel("\n" +
                                    "\n" +
                                    "Commande n• " + this.commande.getId() + " prête à 50%. Temps restant : "+ tempsPreparation/2 + "s \n" +
                                    "\n"
                            );
                        }else{

                            //JOptionPane.showMessageDialog(frame,"Commande prête");
                            fenetre.ajouterLabel("\n" +
                                    "\n" +
                                    "Commande n• " + this.commande.getId() + " prête !\n" +
                                    "\n"
                                    );
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.commande.setEtat(3);

                try {
                    fileManager.addCommandeToFile(this.commande);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
            }
        }
    }

}
