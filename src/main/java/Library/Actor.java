package Library;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Kuki on 02.10.2017.
 */
public class Actor  {

    String imie;
    String nazwisko;

    public void searchByActor() {
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(DataUtils.DIRECTORY));
            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) obj;

            System.out.println("Podaj imie aktora grającego w filmie");
            Scanner inputImie = new Scanner(System.in);
            String imie = inputImie.nextLine();
            System.out.println("Imie: " + imie );
            System.out.println("Podaj nazwisko aktora grającego w filmie");
            Scanner inputNazwisko = new Scanner(System.in);
            String nazwisko = inputNazwisko.nextLine();
            System.out.println("Nazwisko " + nazwisko);
            System.out.println(" ");

            boolean isFilmInDatabase = false;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
                if ((jsonObjectRow.get("actor_first_name").equals(imie)) && (jsonObjectRow.get("actor_last_name").equals(nazwisko))) {
                    isFilmInDatabase = true;
                  DataUtils.printAllMovieData(jsonObjectRow);
                }
            }
            if (isFilmInDatabase == false) System.out.println(" Nie ma aktora o podanym nazwisku: " + imie + " " + nazwisko);


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();

        }
    }
}