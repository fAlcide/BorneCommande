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


public class FileManager implements Serializable{

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
}
