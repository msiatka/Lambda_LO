package pl.sda.lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        AddInterface add = (a, b) -> a + b;
        add.calc(4, 2);

        List<Integer> numbers = Arrays.asList(1, 2,3,4,5,6,7);

        for (Integer integer: numbers){
            System.out.println(integer);
        }

        Consumer<Integer> integerConsumer = n -> System.out.println(n) ;
        numbers.forEach(integerConsumer);

        numbers.forEach(s -> System.out.println(s));
        numbers.forEach(System.out::println);

        List<Movie> movies = Arrays.asList(
                new Movie("Tytul",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        60,
                        Arrays.asList("Michal", "Maciek")),
                new Movie("Tytul2",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        20,
                        Arrays.asList("Michal", "Maciek")),
                 new Movie("Tytul3",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        125,
                        Arrays.asList("Michal", "Maciek"))
        );


        List<String> titles = movies
                .stream()
                .map(f -> f.getTitle())  //mozna sie dostac za pomoca referencji ::
                .collect(Collectors.toList());

        //drugi stream - lista directors

        //iteracja po liscie

        titles.forEach(System.out::println);

        System.out.println(titles);


        List<Movie> movieList = movies.stream()
                .filter(f -> f.getPrice() > 50)
                .filter(f -> f.getTitle().length() > 5)
                .collect(Collectors.toList());

        movieList.forEach(p-> System.out.println(p.getTitle() + p.getPrice()));
        movieList.forEach(System.out::println);

        //zwroc liste tytulow filmow ktorych getPrice > 10 i < 30

        List<String> movieList1 = movies.stream()
                .filter(f -> f.getPrice() > 10)
                .filter(f -> f.getPrice() < 30)
                .map(f-> f.getTitle())
                .collect(Collectors.toList());
        System.out.println(" _____ ");
       movieList1.forEach(System.out::println);



    }
}
