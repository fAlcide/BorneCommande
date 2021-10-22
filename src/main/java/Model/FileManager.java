package Model;

import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
}
