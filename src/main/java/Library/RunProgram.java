package Library;

import java.util.Scanner;

/**
 * Created by Kuki on 03.10.2017.
 */
public class RunProgram {

    public static void main(String[] args) {


        System.out.println("Witaj w programie Baza Filmów");
        Movie movie = new Movie();
        movie.insertNewMovie();


        System.out.println("Czy chcesz dodać nowy plik do Biblioteki? Wpisz T jeśli TAK, naciśnij jakikolwiek znak jeśli NIE.");
        Scanner inputDecision = new Scanner(System.in);
        String decision = inputDecision.nextLine();
        while(decision.equals("T")){
            movie.insertNewMovie();
        }

        ImportDatabase json = new ImportDatabase ();
        json.displayLibrary();

        Year year = new Year();
        year.SearchByYear();

        Phrase phrase = new Phrase ();
        phrase.searchByPhrase();

        Title tytul = new Title ();
        tytul.SearchByTitle();

        Type typ = new Type();
        typ.searchByFilmGenre();

        Actor aktor = new Actor();
        aktor.searchByActor();
    }
}
