package Library;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Kuki on 05.10.2017.
 */
public class ImportDatabase {

    public void displayLibrary () {
        try {
            JSONParser jsonParser = new JSONParser();

            Object obj = jsonParser.parse(new FileReader(DataUtils.DIRECTORY));

            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) obj;

            for (int i = 0; i < jsonArray.size(); i++) {
                String fullJson = jsonArray.get(i).toString();
                //wyświetl całego jsona
                System.out.println(fullJson);

                //wyświetl każdy item w json
                JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
                DataUtils.printAllMovieData(jsonObjectRow);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();


        }
    }
}
