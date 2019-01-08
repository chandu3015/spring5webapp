package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      initData();
    }


    public void initData()
    {
        Author eric = new Author("Eric","Evans");
        Publisher tata = new Publisher("Tata Publications","Delhi");
        Book ddd = new Book("Domain Driven Desgin","1234",tata );
        eric.getBooks().add(ddd);

        publisherRepository.save(tata);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        Author rod = new Author("Hod","Johnson");
        Publisher birla = new Publisher("Birla Publications","Mumbai");
        Book noEJB = new Book("J2EE Development Without EJB","23444",birla );
        eric.getBooks().add(noEJB);
        publisherRepository.save(birla);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
