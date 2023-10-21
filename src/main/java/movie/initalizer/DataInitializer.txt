package movie.initalizer;


import movie.model.Movie;
import movie.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository; // Replace with your repository

    public DataInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {

        List<Movie> movies = movieRepository.findAll();

        if (movies.size()>1) {
            System.out.println("already there is movie so skipping these movies");
        } else {
            // Insert initial data into the table
            Movie movie1 = new Movie("The Grudge", 2020, new String[]{"Andrea Riseborough", "Demián Bichir", "John Cho", "Betty Gilpin", "Lin Shaye", "Jacki Weaver"}, new String[]{"Horror", "Supernatural"}, "The_Grudge_(2020_film)", "The Grudge is a 2020 American psychological supernatural horror film...", "https://upload.wikimedia.org/wikipedia/en/3/34/The_Grudge_2020_Poster.jpeg", 220, 326);
            Movie movie2 = new Movie("Underwater", 2020, new String[]{"Kristen Stewart", "Vincent Cassel", "Jessica Henwick", "John Gallagher Jr.", "Mamoudou Athie", "T.J. Miller"}, new String[]{"Action", "Horror", "Science Fiction"}, "Underwater_(film)", "Underwater is a 2020 American science fiction action horror film...", "https://upload.wikimedia.org/wikipedia/en/4/4a/Underwater_poster.jpeg", 250, 398);

            Movie movie3 = new Movie("Like a Boss", 2020, new String[]{"Tiffany Haddish", "Rose Byrne", "Salma Hayek", "Jennifer Coolidge", "Billy Porter"}, new String[]{"Comedy"}, "Like_a_Boss_(film)", "Like a Boss is a 2020 American comedy film directed by Miguel Arteta...", "https://upload.wikimedia.org/wikipedia/en/9/9a/LikeaBossPoster.jpg", 259, 383);

            Movie movie4 = new Movie("Three Christs", 2020, new String[]{"Richard Gere", "Peter Dinklage", "Walton Goggins", "Bradley Whitford"}, new String[]{"Drama"}, "Three_Christs", "Three Christs, also known as State of Mind, is a 2017 American drama film...", "https://upload.wikimedia.org/wikipedia.org/a/a1/Three_Christs_poster.jpg", 259, 383);

            Movie movie5 = new Movie("Inherit the Viper", 2020, new String[]{"Josh Hartnett", "Margarita Levieva", "Chandler Riggs", "Bruce Dern", "Owen Teague"}, new String[]{"Crime", "Drama"}, "Inherit_the_Viper", "Inherit the Viper is a 2019 American crime drama film directed by Anthony Jerjen, in his feature directorial debut, from a screenplay by Andrew Crabtree. It stars Josh Hartnett, Margarita Levieva, Chandler Riggs, Bruce Dern, Valorie Curry, Owen Teague, and Dash Mihok.", "https://upload.wikimedia.org/wikipedia/en/1/1c/Inherit_the_Viper_%282019%29_Film_Poster.jpg", 236, 350);

            Movie movie6 = new Movie("The Sonata", 2020, new String[]{"Freya Tingley", "Simon Abkarian", "Rutger Hauer", "James Faulkner"}, new String[]{"Mystery", "Thriller"}, "The_Sonata_(film)", "The Sonata is a 2018 mystery thriller film, directed by Andrew Desmond, from a screenplay by Desmond and Arthur Morin. It stars Freya Tingley, Simon Abkarian, James Faulkner, Rutger Hauer, Matt Barber and James Kermack. It was released in the United States on January 10, 2020, by Screen Media Films. It grossed $146,595 at the box office and received mixed reviews from critics.", "https://upload.wikimedia.org/wikipedia/en/1/13/The_Sonata_%282018%29_Film_Poster.jpg", 246, 350);

            Movie movie7 = new Movie("The Murder of Nicole Brown Simpson", 2020, new String[]{"Mena Suvari", "Nick Stahl", "Taryn Manning"}, new String[]{"Crime", "Horror"}, "The_Murder_of_Nicole_Brown_Simpson", "The Murder of Nicole Brown Simpson is a 2019 American crime horror film directed by Daniel Farrands. The film is loosely based on the murder of Nicole Brown Simpson, presenting a version of events in which Brown Simpson is murdered by serial killer Glen Edward Rogers, and not by O. J. Simpson, her ex-husband and the primary suspect in the case. Though Mena Suvari's performance as Nicole Brown was praised, the film was panned by critics.", "https://upload.wikimedia.org/wikipedia/en/e/ed/The_Murder_of_Nicole_Brown_Simpson_poster.jpg", 263, 380);

            Movie movie8 = new Movie("Bad Boys for Life", 2020, new String[]{"Will Smith", "Martin Lawrence", "Vanessa Hudgens", "Alexander Ludwig", "Charles Melton", "Paola Núñez", "Kate del Castillo", "Nicky Jam", "Joe Pantoliano"}, new String[]{"Action", "Comedy"}, "Bad_Boys_for_Life", "Bad Boys for Life is a 2020 American buddy cop action comedy film directed by Adil & Bilall. It is the sequel to Bad Boys II (2003) and the third installment in the Bad Boys franchise. Will Smith, Martin Lawrence, Joe Pantoliano and Theresa Randle reprise their roles in the film and are joined by Paola Núñez, Vanessa Hudgens, Jacob Scipio, Alexander Ludwig, Charles Melton, Kate del Castillo and Nicky Jam. The film was produced by Smith, Jerry Bruckheimer, and Doug Belgrad, with a screenplay written by Chris Bremner, Peter Craig and Joe Carnahan. In Bad Boys for Life, Miami detectives Mike Lowrey and Marcus Burnett investigate a string of murders tied to Lowrey's troubled past.", "https://upload.wikimedia.org/wikipedia/en/9/90/Bad_Boys_for_Life_poster.jpg", 219, 325);

            Movie movie9 = new Movie("Dolittle", 2020, new String[]{"Robert Downey Jr.", "Antonio Banderas", "Michael Sheen", "Emma Thompson", "Rami Malek", "John Cena", "Kumail Nanjiani", "Octavia Spencer", "Tom Holland", "Craig Robinson", "Ralph Fiennes", "Selena Gomez", "Marion Cotillard"}, new String[]{"Adventure", "Fantasy"}, "Dolittle_(film)", "Dolittle is a 2020 American fantasy adventure film directed by Stephen Gaghan from a screenplay by Gaghan, Dan Gregor, and Doug Mand, based on a story by Thomas Shepherd. Dolittle is based on the title character created by Hugh Lofting and is primarily inspired by the author's second Doctor Dolittle book, The Voyages of Doctor Dolittle (1922). Robert Downey Jr. stars as the title character, alongside Antonio Banderas and Michael Sheen in live-action roles, with Emma Thompson, Rami Malek, John Cena, Kumail Nanjiani, Octavia Spencer, Tom Holland, Craig Robinson, Ralph Fiennes, Selena Gomez, and Marion Cotillard voicing an array of creatures.", "https://upload.wikimedia.org/wikipedia/en/1/1f/Dolittle_%282020_film_poster%29.png", 220, 326);

            Movie movie10 = new Movie("A Fall from Grace", 2020, new String[]{"Crystal R. Fox", "Phylicia Rashad", "Bresha Webb", "Mehcad Brooks", "Cicely Tyson", "Tyler Perry"}, new String[]{"Thriller"}, "A_Fall_from_Grace", "A Fall from Grace is a 2020 American thriller film produced, written, and directed by Tyler Perry and his first to be released by Netflix. The film follows a woman who finds a dangerous new love and the novice attorney who defends her in a sensational court case. This was the final film of actor Cicely Tyson before her death in January 2021.", "https://upload.wikimedia.org/wikipedia/en/4/4e/AFallFromGrace.png", 259, 383);



            movieRepository.save(movie1);
            movieRepository.save(movie2);
            movieRepository.save(movie3);
            movieRepository.save(movie4);

            movieRepository.save(movie5);
            movieRepository.save(movie6);


            movieRepository.save(movie7);
            movieRepository.save(movie8);

//        movieRepository.save(movie9);
//        movieRepository.save(movie10);
        }

    }
}