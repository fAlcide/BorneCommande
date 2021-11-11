import Model.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Création des cuisin
        Cuisine cuisine1 = new Cuisine("cuisine1");
        Cuisine cuisine2 = new Cuisine("cuisine2");
        Cuisine cuisine3 = new Cuisine("cuisine3");

        // Start des threads des cuisines
        cuisine1.start();
        cuisine2.start();
        cuisine3.start();

        // Instaciation du fileManager pour la gestion de fichiers
        FileManager fm = new FileManager();

        // Ingrédients pour les plats
        Ingredient steak = new IngredientAvecCuisson(1, "Steak", 5, "Grill");
        Ingredient poulet = new IngredientAvecCuisson(2, "Poulet", 8, "Grill");
        Ingredient kebab = new IngredientAvecCuisson(3, "Kebab", 5, "Broche");

        // Ingrédients pour les accompagnements
        Ingredient pdt = new IngredientAvecCuisson(4, "Pomme de terres", 4, "Friteuse");
        Ingredient sauceBurger = new IngredientSansCuisson(5, "Sauce burger");
        Ingredient sauceKebab = new IngredientSansCuisson(6, "Sauce kebab");
        Ingredient pain = new IngredientSansCuisson(7, "Pain");
        Ingredient salade = new IngredientSansCuisson(8, "Salade");
        Ingredient tomate = new IngredientSansCuisson(9, "Tomate");
        Ingredient oignon = new IngredientSansCuisson(10, "Oignon");

        // Ingrédients pour les boissons
        Ingredient coca = new IngredientSansCuisson(11, "Coca");
        Ingredient eau = new IngredientSansCuisson(12, "Eau");
        Ingredient iceTea = new IngredientSansCuisson(13, "Ice-tea");
        Ingredient jusOrange = new IngredientSansCuisson(14, "Jus d'orange");

        // Création des listes d'ingrédients de chaque plat
        // Burger Steak
        ArrayList<Ingredient> burgerListe = new ArrayList<>();
        burgerListe.add(pain);
        burgerListe.add(steak);
        burgerListe.add(salade);
        burgerListe.add(tomate);
        burgerListe.add(oignon);

        // Wrap
        ArrayList<Ingredient> wrapListe = new ArrayList<>();
        burgerListe.add(pain);
        burgerListe.add(poulet);
        burgerListe.add(salade);
        burgerListe.add(tomate);
        burgerListe.add(oignon);

        // Création des listes d'ingrédients de chaque boisson
        // Coca
        ArrayList<Ingredient> cocaListe = new ArrayList<>();
        cocaListe.add(coca);

        // Ice tea
        ArrayList<Ingredient> iceTeaListe = new ArrayList<>();
        iceTeaListe.add(iceTea);

        // Eau
        ArrayList<Ingredient> eauListe = new ArrayList<>();
        iceTeaListe.add(eau);

        // Jus d'orange
        ArrayList<Ingredient> jusListe = new ArrayList<>();
        iceTeaListe.add(jusOrange);

        // Création des listes d'ingrédients de chaque accompagement
        // Frite
        ArrayList<Ingredient> friteListe = new ArrayList<>();
        friteListe.add(pdt);

        // Potatoes
        ArrayList<Ingredient> potatoesListe = new ArrayList<>();
        friteListe.add(pdt);

        // Creation des plats
        Plat burger = new Plat(1, "Burger", burgerListe, 6, true, 1);
        Plat wrap = new Plat(1, "Wrap", wrapListe, 7, false, 1);

        // Création des accompagnements
        Accompagnement frite = new Accompagnement(1, "Frite", friteListe, 3, true, 1);
        Accompagnement potatoes = new Accompagnement(1, "Potatoes", potatoesListe, 4, true, 1);

        // Création des boissons
        Boisson cocaBoisson = new Boisson(1, "Coca", cocaListe, 1, true, 1);
        Boisson iceTeaBoisson = new Boisson(1, "Ice Tea", iceTeaListe, 1, true, 1);
        Boisson eauBoisson = new Boisson(1, "Eau", eauListe, 1, true, 1);
        Boisson jusBoisson = new Boisson(1, "Jus d'orange", jusListe, 1, true, 1);

        // Ajout dans les fichiers
        // ----------------------------------------------------------------------- //

        // Ajout des boissons dans les fichiers
        ArrayList<Boisson> listeBoissonsAjout = new ArrayList<>();
        listeBoissonsAjout.add(eauBoisson);
        listeBoissonsAjout.add(jusBoisson);
        listeBoissonsAjout.add(cocaBoisson);
        listeBoissonsAjout.add(iceTeaBoisson);

        for (Boisson boisson: listeBoissonsAjout
        ) {
            fm.addBoissonInFile(boisson);
        }

        // Ajout des plats dans les fichiers
        ArrayList<Plat> listePlatsAjout = new ArrayList<>();
        listePlatsAjout.add(burger);
        listePlatsAjout.add(wrap);

        for (Plat plat: listePlatsAjout
             ) {
            fm.addPlatInFile(plat);
        }

        // Ajout des accompagnements dans les fichiers
        ArrayList<Accompagnement> listeAccompagnementsAjout = new ArrayList<>();
        listeAccompagnementsAjout.add(frite);

        for (Accompagnement accompagnement: listeAccompagnementsAjout
             ) {
            fm.addAccompagnementInFile(accompagnement);
        }

        // ----------------------------------------------------------------------- //

        // Récupération de toutes les boissons dans les fichiers
        ArrayList<Boisson> listeBoissons = fm.getBoissonFromFile();

        // Récupération des plats dans les fichiers
        ArrayList<Plat> listePlats = fm.getPlatFromFile();

        // Récupération des tous les accompagements dans les fichiers
        ArrayList<Accompagnement> listeAccompagnements = fm.getAccompagnementsFromFile();

        // Instantiation de la vue
        Vue vue = new Vue(listeBoissons, listePlats, listeAccompagnements, fm);

        // Démarrage de la borne
        while(true){
            int choix = vue.choixAccueil();
        }
    }
}
