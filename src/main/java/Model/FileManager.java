package Model;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

//En faire un singleton des que possible
public class FileManager implements Serializable{

    private static FileManager instanceOf = null;

    private FileManager(){

    }

    public static FileManager getInstance() {
        if(instanceOf == null){
            return new FileManager();
        }else {
            return instanceOf;
        }
    }

    // ---------- BOISSONS -------------
    public void ajouterBoisson(Boisson boisson) throws IOException, ClassNotFoundException {

        //Write Student array to file.
        FileOutputStream fos = new FileOutputStream("Data/Boissons/" + boisson.getNom() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(boisson);
        oos.close();
    }

    public ArrayList<Boisson> getBoissonFromFile() throws IOException, ClassNotFoundException {
        File folder = new File("Data/Boissons");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> nomObjets = new ArrayList<>();

        //Récupère tous les nom des fichiers du dossier renseigner
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                nomObjets.add(listOfFiles[i].getName());

            } else if (listOfFiles[i].isDirectory()) {
            }
        }

        ArrayList<Boisson> boissonsOut = new ArrayList<>();
        //Lis chaque fichier selon les nom récupérés
        for (Object nom:nomObjets
        ) {
            FileInputStream fis = new FileInputStream("Data/Boissons/" + nom);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Boisson boissonFromFile = (Boisson) ois.readObject();
            boissonsOut.add(boissonFromFile);
            ois.close();
        }
        return boissonsOut;
    }

    // ---------- PLATS -------------
    public void addPlatInFile(Plat plat) throws IOException, ClassNotFoundException {

        //Write Student array to file.
        FileOutputStream fos = new FileOutputStream("Data/Plats/" + plat.getNom() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(plat);
        oos.close();
    }

    public ArrayList<Plat> getPlatFromFile() throws IOException, ClassNotFoundException {
        File folder = new File("Data/Plats");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> nomObjets = new ArrayList<>();

        //Récupère tous les nom des fichiers du dossier renseigner
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                nomObjets.add(listOfFiles[i].getName());

            } else if (listOfFiles[i].isDirectory()) {
            }
        }

        ArrayList<Plat> platOut = new ArrayList<>();
        //Lis chaque fichier selon les nom récupérés
        for (Object nom:nomObjets
        ) {
            FileInputStream fis = new FileInputStream("Data/Plats/" + nom);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Plat platFromFile = (Plat) ois.readObject();
            platOut.add(platFromFile);
            ois.close();
        }
        return platOut;
    }

    // ---------- ACCOMPAGNEMENTS -------------
    public void addAccompagnementInFile(Accompagnement accompagnement) throws IOException, ClassNotFoundException {

        //Write Student array to file.
        FileOutputStream fos = new FileOutputStream("Data/Accompagnements/" + accompagnement.getNom() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(accompagnement);
        oos.close();
    }

    public ArrayList<Accompagnement> getAccompagnementsFromFile() throws IOException, ClassNotFoundException {
        File folder = new File("Data/Accompagnements");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> nomObjets = new ArrayList<>();

        //Récupère tous les nom des fichiers du dossier renseigner
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                nomObjets.add(listOfFiles[i].getName());

            } else if (listOfFiles[i].isDirectory()) {
            }
        }

        ArrayList<Accompagnement> accompagnementOut = new ArrayList<>();
        //Lis chaque fichier selon les nom récupérés
        for (Object nom:nomObjets
        ) {
            FileInputStream fis = new FileInputStream("Data/Accompagnements/" + nom);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Accompagnement accompagnement = (Accompagnement) ois.readObject();
            accompagnementOut.add(accompagnement);
            ois.close();
        }
        return accompagnementOut;
    }

    //Creation de User
    public void addUserToFile(Utilisateur user) throws IOException, ClassNotFoundException {

        //Write Student array to file.
        FileOutputStream fos = new FileOutputStream("Data/Users/" + user.getId() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
    }

    public Utilisateur getUserByIdFromFile(String id) throws IOException, ClassNotFoundException {
        File folder = new File("Data/Users");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> nomObjets = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream("Data/Users/" + id + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Utilisateur user = (Utilisateur) ois.readObject();
            ois.close();
            return user;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    //Génération d'un id utilisateur unique
    public String getNewId() throws IOException, ClassNotFoundException {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        Utilisateur idGenere = this.getUserByIdFromFile(generatedString);

        while(idGenere != null){
            buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            generatedString = buffer.toString();
            idGenere = this.getUserByIdFromFile(generatedString);
        }
        return generatedString;
    }

    //Sauvegarde d'une commande en fichiers
    public void addCommandeToFile(Commande commande) throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("Data/Commandes/" + commande.getId() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(commande);
        oos.close();
    }

    //Récupération de commande par Id
    public Commande getCommandeById(int id) throws IOException, ClassNotFoundException {
        File folder = new File("Data/Commandes");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> nomObjets = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream("Data/Commandes/" + id + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Commande commande = (Commande) ois.readObject();
            ois.close();
            return commande;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    //Génération id commande
    public int generationIdCommande() throws IOException, ClassNotFoundException {
        File folder = new File("Data/Commandes");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Integer> nomCommandes = new ArrayList<>();

        if(listOfFiles.length > 0){

            for (File file:listOfFiles
                 ) {
                nomCommandes.add(Integer.parseInt(file.getName().replace(".ser", "")));
            }

            // Tri du nom des fichiers
            Collections.sort(nomCommandes);

            return nomCommandes.get(nomCommandes.size() - 1) + 1;
        }else{
            return 1;
        }
    }

    //Récupération de toutes les commandes
    public ArrayList<Commande> getAllCommandesByIdUser(Utilisateur user) throws IOException {
        File folder = new File("Data/Commandes");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Commande> commandes = new ArrayList<>();

        for (File file:listOfFiles
             ) {
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Commande commande = (Commande) ois.readObject();
                if(commande.getUtilisateur().getId().compareTo(user.getId()) == 0){
                    commandes.add(commande);
                }
                ois.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return commandes;
    }

    // Nombre de commande en attente de préparation
    public void nombreCommandeAPreparer(){
        File folder = new File("Data/Commandes");
        File[] listOfFiles = folder.listFiles();
        int cpt = 0;
        for (File file:listOfFiles
        ) {
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Commande commande = (Commande) ois.readObject();
                if(commande.getEtat() == 1){
                    if(commande.getEtat() == 1) {
                        cpt++;
                    }
                }else{
                    ois.close();
                }
                ois.close();
            } catch (ClassNotFoundException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Nombre de commande en attente de prise en charge : " + cpt);
    }

    // Récupération de la prochaine commandes à préparer
    public Commande getCommandeToCook(){
        //nombreCommandeAPreparer();
        File folder = new File("Data/Commandes");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Commande> commandes = new ArrayList<>();
        for (File file:listOfFiles
        ) {
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Commande commande = (Commande) ois.readObject();
                if(commande.getEtat() == 1){
                    return commande;
                }

            } catch (ClassNotFoundException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
