package Model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jdk.jshell.execution.Util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

//En faire un singleton des que possible
public class FileManager implements Serializable{

    // ---------- BOISSONS -------------
    public void addBoissonInFile(Boisson boisson) throws IOException, ClassNotFoundException {

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
}
