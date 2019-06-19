package haoren.springbase.demo.bootstrap;

import haoren.springbase.demo.model.Author;
import haoren.springbase.demo.model.Book;
import haoren.springbase.demo.model.Publisher;
import haoren.springbase.demo.repositories.AuthorRepository;
import haoren.springbase.demo.repositories.BookRepository;
import haoren.springbase.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher hc = new Publisher("Harper Collins", "400 Boren Ave N, WA, Seattle, 98109");
        Publisher wx = new Publisher("Worx", "4609 Bayard Street, PA, Pittsburgh, 15213");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "5678", wx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(hc);
        publisherRepository.save(wx);

        authorRepository.save(eric);
        authorRepository.save(rod);

        bookRepository.save(ddd);
        bookRepository.save(noEJB);
    }
}
