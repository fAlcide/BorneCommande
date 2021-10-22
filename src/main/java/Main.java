import Model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {

        FileManager fm = new FileManager();

        Ingredient steak = new IngredientAvecCuisson(1, "Steak", 10, "Grill");
        Ingredient poulet = new IngredientAvecCuisson(2, "Poulet", 8, "Grill");
        Ingredient kebab = new IngredientAvecCuisson(3, "Kebab", 5, "Broche");
        Ingredient pdt = new IngredientAvecCuisson(4, "Pomme de terres", 5, "Friteuse");
        Ingredient sauceBurger = new IngredientSansCuisson(5, "Sauce burger");
        Ingredient sauceKebab = new IngredientSansCuisson(6, "Sauce kebab");
        Ingredient pain = new IngredientSansCuisson(7, "Pain");
        Ingredient salade = new IngredientSansCuisson(8, "Salade");
        Ingredient tomate = new IngredientSansCuisson(9, "Tomate");
        Ingredient oignon = new IngredientSansCuisson(10, "Oignon");
        Ingredient coca = new IngredientSansCuisson(11, "Coca");
        Ingredient eau = new IngredientSansCuisson(12, "eau");
        Ingredient iceTea = new IngredientSansCuisson(13, "Ice-tea");
        Ingredient jusOrange = new IngredientSansCuisson(14, "Jus d'orange");

        ArrayList<Ingredient> burgerListe = new ArrayList<>();
        burgerListe.add(pain);
        burgerListe.add(steak);
        burgerListe.add(salade);
        burgerListe.add(tomate);
        burgerListe.add(oignon);



        ArrayList<Ingredient> cocaListe = new ArrayList<>();
        cocaListe.add(coca);

        ArrayList<Ingredient> friteListe = new ArrayList<>();
        friteListe.add(pdt);

        ArrayList<Ingredient> iceTeaListe = new ArrayList<>();
        iceTeaListe.add(iceTea);

        Plat burger = new Plat(1, "Burger", burgerListe, 6, true, 1);

        Boisson cocaProduit = new Boisson(1, "Coca", cocaListe, 1, true, 1);
        Accompagnement frite = new Accompagnement(1, "Frite", friteListe, 3, true, 1);

        Boisson iceTeaBoisson = new Boisson(1, "Ice Tea", iceTeaListe, 1, true, 1);
        ArrayList<Menu> listeMenus = new ArrayList<>();

        ArrayList<Boisson> listeBoissons = new ArrayList<>();
        listeBoissons.add(cocaProduit);
        listeBoissons.add(iceTeaBoisson);

        for (Boisson boisson: listeBoissons
             ) {
            fm.addBoissonInFile(boisson);
        }

        fm.getBoissonFromFile();



        /*for (Boisson boisson: listeBoissons
        ) {
            coca.addBoissonInFile(boisson);
        }

        coca.getBoissonFromFile();

         */

        ArrayList<Plat> listePlats = new ArrayList<>();
        listePlats.add(burger);

        ArrayList<Accompagnement> listeAccompagnements = new ArrayList<>();
        listeAccompagnements.add(frite);

        Vue vue = new Vue(listeBoissons, listePlats, listeAccompagnements);
        int choix = vue.choixAccueil();
        System.out.println(choix);

        /*ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString("test");
            System.out.println("ResultingJSONstring = " + json);
            FileWriter file = new FileWriter("././Data/Produits.json");
            file.write(json);
            file.close();
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        */
    }
}
