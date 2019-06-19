package haoren.springbase.demo.bootstrap;

import haoren.springbase.demo.model.Author;
import haoren.springbase.demo.model.Book;
import haoren.springbase.demo.repositories.AuthorRepository;
import haoren.springbase.demo.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "5678", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(eric);
        authorRepository.save(rod);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);
    }
}
