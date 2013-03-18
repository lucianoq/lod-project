import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        MovieLensVoting.init();
        System.out.println(MovieLensVoting.users());

        System.exit(0);
        Grafo.init();
        Grafo.load();

//        Grafo.createFromQuery();
//        Grafo.save();
//
//      Grafo.updateWeight();
//      Grafo.save();
//

        Grafo.printDot();

        System.out.println("Grafo generale creato o caricato");


        List<Film> films = Grafo.getFilms();

        FilmGraph.init();
        FilmGraph.printDot();

        System.out.println("Grafo dei film creato");

        Recommender.init();

        Set<Film> liked = new HashSet<Film>();
        liked.add(films.get(2));

        System.out.println(films.get(2));

        Profile profile = new Profile(liked);

        List<Recommendation> recommendations = Recommender.getRecommendations(profile, Recommender.ALL);
        System.out.println("Recommendations size: " + recommendations.size());
        for (Recommendation r : recommendations) {
            System.out.println("Film: " + r.getFilm().getTitle() + "\t\tDistance: " + r.getDistance());


//        for (int i = 0; i < films.size(); i++) {
//            for (int j = i + 1; j < films.size(); j++) {
//                System.out.println();
//                System.out.println("----> Tra : " + films.get(i).getTitle() + " con " + films.get(j).getTitle());
//                System.out.println("Directed " + d.passantD(films.get(i), films.get(j)));
//                System.out.println("DirectedW " + d.passantDW(films.get(i), films.get(j)));
//                System.out.println("Indirected " + d.passantI(films.get(i), films.get(j)));
//                System.out.println("IndirectedW " + d.passantIW(films.get(i), films.get(j)));
//                System.out.println("Combined " + d.passantC(films.get(i), films.get(j)));
//                System.out.println("CombinedW " + d.passantCW(films.get(i), films.get(j)));
//                System.out.println("Nostra " + d.nostra(films.get(i), films.get(j)));
//            }

        }

    }
}
