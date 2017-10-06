package Library;

import org.json.simple.JSONObject;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.parser.JSONParser;

/**
 * Created by Kuki on 02.10.2017.
 */
public class Movie {


    public void insertNewMovie() {


        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(DataUtils.TEMPDIRECTORY));



            System.out.println("Wpisz tytuł");
            Scanner inputTytul = new Scanner(System.in);
            String tytul = inputTytul.nextLine();
            DataUtils.validateDataTitle(tytul);


            System.out.println("Wpisz rok");
            Scanner inputRok = new Scanner(System.in);
            int rok = inputRok.nextInt();
            DataUtils.validateDataYear(rok);

            System.out.println("Dodaj gatunek");
            Scanner inputGatunek = new Scanner(System.in);
            String gatunek = inputGatunek.nextLine();
            DataUtils.validateDataGenre(gatunek);

            System.out.println("Podaj imie rezysera");
            Scanner inputImieRezysera = new Scanner(System.in);
            String imieRezysera = inputImieRezysera.nextLine();
            DataUtils.validateDataName(imieRezysera);

            System.out.println("Dodaj nazwisko rezysera");
            Scanner inputNazwiskoRezysera = new Scanner(System.in);
            String nazwiskoRezysera = inputNazwiskoRezysera.nextLine();
            DataUtils.validateDataName(nazwiskoRezysera);

            System.out.println("Podaj liczbe aktorów");
            Scanner inputLiczbaAktorow = new Scanner(System.in);
            int liczbaAktorow = inputLiczbaAktorow.nextInt();

            JSONObject json = new JSONObject( );
            for (int i=0;i<liczbaAktorow;i++) {
                System.out.println("Podaj imie aktora");
                Scanner inputImieAktora = new Scanner(System.in);
                String imieAktora = inputImieAktora.nextLine();
                DataUtils.validateDataName(imieAktora);
                System.out.println("Dodaj nazwisko aktora");
                Scanner inputNazwiskoAktora = new Scanner(System.in);
                String nazwiskoAktora = inputNazwiskoAktora.nextLine();
                DataUtils.validateDataName(nazwiskoAktora);
                json.put("actor_first_name",imieAktora);
                json.put("actor_last_name",nazwiskoAktora);
            }

            json.put("title", tytul);
            json.put("year", rok);
            json.put("film_genre",gatunek);
            json.put("director_first_name", imieRezysera);
            json.put("director_last_name",nazwiskoRezysera);

            PrintWriter zapis = new PrintWriter(DataUtils.TEMPDIRECTORY);
            zapis.println(json);
            zapis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }
}