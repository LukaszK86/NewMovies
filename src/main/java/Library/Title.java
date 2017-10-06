package Library;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kuki on 02.10.2017.
 */
public class Title extends Movie {

    String nazwa;

//    Title (String nazwa){
//        this.nazwa = nazwa;
//    }

    public void SearchByTitle (){
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(DataUtils.DIRECTORY));
            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) obj;

            System.out.println("Wyszukaj film o wybranym tytule");
            Scanner input = new Scanner(System.in);
            String title = input.nextLine();
            DataUtils.validateDataTitle(title);
            System.out.println();

            boolean isFilmInDatabase = false;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
                if (jsonObjectRow.get("title").equals(title)) {
                    isFilmInDatabase = true;
                    DataUtils.printAllMovieData(jsonObjectRow);
                }
            }

            if (isFilmInDatabase == false) System.out.println(" Nie ma filmu o padanym tytule: " + title);


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
