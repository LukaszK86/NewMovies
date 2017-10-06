package Library;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kuki on 03.10.2017.
 */
public class DataUtils {

    static final String DIRECTORY = "C:\\Users\\Kuki\\IdeaProjects\\MateuszTadla\\src\\Library\\movie_information.json";
    static final String TEMPDIRECTORY = "C:\\Users\\Kuki\\IdeaProjects\\MateuszTadla\\src\\Library\\Test.json";

    static void printAllMovieData (JSONObject jsonObject){
        System.out.println(jsonObject.get("title"));
        System.out.println(jsonObject.get("year"));
        System.out.println(jsonObject.get("film_genre"));
        System.out.println(jsonObject.get("director_first_name") + " " + jsonObject.get("director_last_name"));
        System.out.println(jsonObject.get("actor_first_name") + " " + jsonObject.get("actor_last_name"));
        System.out.println();
    }

//    static List<String> createListWithAllData (JSONObject jsonObject) {
//        List<String> allData = new ArrayList<>();
//        allData.add(jsonObject.get("title").toString());
//        allData.add(jsonObject.get("year").toString());
//        allData.add(jsonObject.get("film_genre").toString());
//        allData.add(jsonObject.get("director_first_name").toString());
//        allData.add(jsonObject.get("director_last_name").toString());
//        allData.add(jsonObject.get("actor_first_name").toString());
//        allData.add(jsonObject.get("actor_last_name").toString());
//    return allData;
//    }

    static void validateDataName (Object object){
        Pattern p = Pattern.compile("[A-Z][a-z]+");
        Matcher m = p.matcher(object.toString());

        boolean matchFound = m.matches();

        if (!matchFound){
            System.out.println("Nieprawidłowe dane. Wyrażenie może zawierać tylko litery. Pierwsza litera powinna być duża.");
        }
    }

    static void validateDataTitle (Object object) {
        Pattern p = Pattern.compile("[A-Za-z0-9\\-?\\s?]{1,20}");
        Matcher m = p.matcher(object.toString());

        boolean matchFound = m.matches();

        if (!matchFound){
            System.out.println("Nieprawidłowe dane. Maksymalna długość wyrażenia wynosi 20 znaków, może zawierać litery, cyfry oraz znak specjalny \"-\".");
        }
    }


    static void validateDataYear (Object object){
        Pattern p = Pattern.compile("[0-9]{4}");
        Matcher m = p.matcher(object.toString());

        boolean matchFound = m.matches();
        if (!matchFound){
            System.out.println("Nieprawidłowy format daty");
        }
        Calendar calendar = Calendar.getInstance();
        int currentYear =calendar.get(Calendar.YEAR);
        if (Integer.parseInt(object.toString())<currentYear-100){
            System.out.println("Przekroczono zakres dat");

        }
        if (Integer.parseInt(object.toString())>currentYear){
            System.out.println("Przekroczono zakres dat");

        }
    }

    static void validateDataGenre (Object object) {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(object.toString());

        boolean matchFound = m.matches();


        if (!matchFound) {
            System.out.println("Nieprawidłowe dane. Wyrażenie może zawierać tylko litery. Pierwsza litera powinna być mała.");
        }
        DataUtils.ListofGenres(object.toString());
    }

        static List<String> createListOfGenres () {

            ArrayList<String> myList = new ArrayList<String>();
            myList.add("horror");
            myList.add("dramat");
            myList.add("komedia");
            myList.add("akcja");
            myList.add("sensacyjny");
            myList.add("thriller");
            System.out.println("Proszę wybrać z listy dostepnych gatunkow: ");

            for (int i = 0; i < myList.size(); i++) {
                System.out.print(myList.get(i) + " ");
            }
            System.out.println();
            return myList;
        }


    static void ListofGenres(Object object) {

        switch (object.toString()) {
            case "horror":
                System.out.println("Dodales: horror ");
                break;
            case "dramat":
                System.out.println("Dodales: dramat");
                break;
            case "komedia":
                System.out.println("Dodales: komedia");
                break;
            case "akcja":
                System.out.println("Dodales: akcja");
                break;
            case "sensacyjny":
                System.out.println("Dodales: sensacyjny");
                break;
            case "thriller":
                System.out.println("Dodales: thriller");
            default:
                System.out.println("Podany gatunek nie istnieje na naszej liście");
                DataUtils.createListOfGenres();


        }
    }
}
