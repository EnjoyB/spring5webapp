package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Daniel Šulik on 23-Jul-19
 * <p>
 * Class DevBootStrap is used for .....
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;
    // It's gonna be autowired


    public DevBootStrap(AuthorRepository authorRepository, PublisherRepository publisherRepository,
                        BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {

        //Micheal
        Author michael = new Author("Michael", "Jojo");
        Publisher publisherOne = new Publisher("GrannyBooks","Mechiko");
        Book masterPiece = new Book("How to do creative things!", "ISJ88521", publisherOne);
        michael.getBooks().add(masterPiece);
        masterPiece.getAuthors().add(michael);


        authorRepository.save(michael);
        publisherRepository.save(publisherOne);
        bookRepository.save(masterPiece);


        //Eve
        Author eve = new Author("Eve", "Stark");
        Publisher publisherTwo = new Publisher("BrokenHearth Print","Maiami city");
        Book lovelyStories = new Book("Is your life as good as you expected it to be?", "6668SF", publisherTwo);
        eve.getBooks().add(lovelyStories);
        lovelyStories.getAuthors().add(eve);

        authorRepository.save(eve);
        publisherRepository.save(publisherTwo);
        bookRepository.save(lovelyStories);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
