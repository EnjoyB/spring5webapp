package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
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
    private BookRepository bookRepository;

    // It's gonna be autowired
    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {

        //Micheal
        Author michael = new Author("Michael", "Jojo");
        Book masterPiece = new Book("How to do creative things!", "ISJ88521", "GrannyBooks");
        michael.getBooks().add(masterPiece);
        masterPiece.getAuthors().add(michael);

        authorRepository.save(michael);
        bookRepository.save(masterPiece);
        

        //Eve
        Author eve = new Author("Eve", "Stark");
        Book lovelyStories = new Book("Is your life as good as you expected it to be?", "6668SF", "BrokenHearth Print");
        eve.getBooks().add(lovelyStories);
        lovelyStories.getAuthors().add(eve);

        authorRepository.save(eve);
        bookRepository.save(lovelyStories);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
