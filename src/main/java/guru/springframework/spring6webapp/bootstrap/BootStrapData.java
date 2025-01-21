package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.entity.Author;
import guru.springframework.spring6webapp.entity.Book;
import guru.springframework.spring6webapp.entity.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("dasd");
        author1.setLastName("dasdad");

        Author author2 = new Author();
        author2.setFirstName("asdas");
        author2.setLastName("asddas");

        Book book1 = new Book();
        book1.setTitle("asdadddd");
        book1.setIsbn("12223132");

        Book book2 = new Book();
        book2.setTitle("dddas");
        book2.setIsbn("ssdddd");

        Publisher publisher = new Publisher();
        publisher.setAddress("asdads");
        publisher.setPublisherName("asdassd");
        publisher.setCity("asdddas");
        publisher.setState("sdddassd");
        publisher.setZip("sasddddsa");

        Author author1Saved = authorRepository.save(author1);
        Author author2Saved = authorRepository.save(author2);
        Book book1Saved = bookRepository.save(book1);
        Book book2Saved = bookRepository.save(book2);
        Publisher publisherSaved = publisherRepository.save(publisher);

        book1Saved.getAuthors().add(author1Saved);
        book1Saved.getAuthors().add(author2Saved);
        book2Saved.getAuthors().add(author2Saved);
        author1Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book2Saved);
        book1Saved.setPublisher(publisherSaved);
        book2Saved.setPublisher(publisherSaved);

        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);
        authorRepository.save(author1Saved);
        authorRepository.save(author2Saved);
        publisherRepository.save(publisherSaved);

        System.out.println("authors = " + authorRepository.count());
        System.out.println("books = " + bookRepository.count());
        System.out.println("publishers = " + publisherRepository.count());
    }
}
