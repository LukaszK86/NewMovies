package Library;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Kuki on 02.10.2017.
 */
public class Year {

    int year;

    public void SearchByYear() {
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(DataUtils.DIRECTORY));
            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) obj;

            System.out.println("Wyszukaj film w danym okresie (w bibliotece zawarte są filmy z ostatnich 100 lat.");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            System.out.println("Aktualna data to: " + dtf.format(localDate));
            System.out.println("Podaj pierwsza date");
            Scanner input1 = new Scanner(System.in);
            int year1 = input1.nextInt();


            System.out.println("Podaj druga date");
            Scanner input2 = new Scanner(System.in);
            int year2 = input2.nextInt();
            System.out.println();

            Calendar calendar = Calendar.getInstance();
            int currentYear =calendar.get(Calendar.YEAR);

            if((year1>currentYear-100)||((year1|year2)<currentYear)) {
                boolean isFilmInDatabase = false;
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
                    if (year1 < Integer.parseInt(jsonObjectRow.get("year").toString()) && Integer.parseInt(jsonObjectRow.get("year").toString()) < year2) {
                        isFilmInDatabase = true;
                        DataUtils.printAllMovieData(jsonObjectRow);
                    }
                }

                if (isFilmInDatabase == false) System.out.println(" Nie znaleziono filmu w podanym przedziale czasu: " + year1 + " " + year2 + ".");
            } else System.out.println("Przekroczono zakres dat");

        }



        catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
