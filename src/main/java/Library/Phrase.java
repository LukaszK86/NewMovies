package Library;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kuki on 03.10.2017.
 */
public class Phrase {

    public void searchByPhrase() {

        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(DataUtils.DIRECTORY));
            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) obj;

            System.out.println("Wyszukaj tytul filmu po dowolnym wyrazeniu");
            Scanner inputPhrase = new Scanner(System.in);
            String phrase = inputPhrase.nextLine();
            System.out.println();

            boolean isPhraseInDatabase = false;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);

                if ((jsonObjectRow.get("title").toString().contains(phrase))) {
                    isPhraseInDatabase = true;
                    DataUtils.printAllMovieData(jsonObjectRow);
                }
            }

            if (isPhraseInDatabase == false) System.out.println(" Nie ma filmu o podanym wyrażeniu: " + phrase);


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();

        }
    }
}
