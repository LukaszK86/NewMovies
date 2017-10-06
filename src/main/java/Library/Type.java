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
public class Type  {




    public void searchByFilmGenre() {
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(DataUtils.DIRECTORY));
            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) obj;

            System.out.println("Wyszukaj gatunek w bibliotece filmow");
            Scanner inputGenre = new Scanner(System.in);
            String genre = inputGenre.nextLine();
            DataUtils.ListofGenres(genre);
            System.out.println();


            boolean isFilmInDatabase = false;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
                if (jsonObjectRow.get("film_genre").equals(genre)) {
                    isFilmInDatabase = true;
                    DataUtils.printAllMovieData(jsonObjectRow);
                }
            }

            if (isFilmInDatabase == false) System.out.println(" Nie ma filmu o podanym gatunku: " + genre);


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();

        }
    }
}