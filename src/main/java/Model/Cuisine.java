package Model;

import java.io.File;

public class Cuisine extends Thread{

    private String nom;
    private Commande commande;
    private FileManager fileManager = new FileManager();

    public Cuisine(){
    }

    public Cuisine(String nom){
        this.nom = nom;
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
                System.out.println("\n" +
                        "------------------------------------\n" +
                        "Commande " + this.getCommande().getId() + " en cours de préparation. Temps d'attente estimé : " + tempsPreparation + " secondes\n" +
                        "------------------------------------\n"
                );

                /*

                try {
                    sleep(tempsPreparation * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                 */


            }
        }
    }

}
