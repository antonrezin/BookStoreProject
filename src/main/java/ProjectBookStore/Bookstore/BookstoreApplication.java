package ProjectBookStore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ProjectBookStore.Bookstore.domain.Book;
import ProjectBookStore.Bookstore.domain.BookStoreRepository;
import ProjectBookStore.Bookstore.domain.Category;
import ProjectBookStore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookStoreRepository repository, CategoryRepository crepository) {
	    return (args) -> {
	    	crepository.save(new Category(""));
	    	crepository.save(new Category("Finance"));
	    	crepository.save(new Category("Investing"));
	    	crepository.save(new Category("Business"));
	    	
	    	repository.save(new Book("Think and Grow Rich", "Napoleon Hill", 1937, "978-1604591873", 8.99, crepository.findByName("Business").get(0)));
	    	repository.save(new Book("The Snowball", "Alice Schroeder", 2008, "978-0553805093", 17.99, crepository.findByName("Business").get(0)));
	    	repository.save(new Book("Rich Dad, Poor Dad", "Robert T. Kiyosaki", 1997, "978-0446677455", 10.99, crepository.findByName("Finance").get(0)));
	    	repository.save(new Book("The Essays of Warren Buffett", "Warren Buffett", 1997, "978-0966446128", 12.99, crepository.findByName("Finance").get(0)));
	    	repository.save(new Book("The Only Investment Guide You'll Ever Need", "Andrew Tobias", 1978, "978-0544781931", 11.99, crepository.findByName("Finance").get(0)));
	    	repository.save(new Book("The Book on Rental Property Investing", "Brandon Turner", 2015, "978-0990711797", 14.99, crepository.findByName("Finance").get(0)));
	    	repository.save(new Book("The Money Manual", "Tonya B. Rapley", 2018, "978-1633537494", 13.99, crepository.findByName("Finance").get(0)));
	    	repository.save(new Book("The Intelligent Investor", "Benjamin Graham", 1949, "978-0062312686", 15.99, crepository.findByName("Investing").get(0)));
	    	repository.save(new Book("The Little Book of Common Sense Investing", "John C. Bogle", 2007, "978-0470102107", 9.99, crepository.findByName("Investing").get(0)));
	    	repository.save(new Book("A Beginner's Guide to the Stock Market", "Matthew R. Kratter", 2019, "978-1793297669", 6.99, crepository.findByName("Investing").get(0)));

	    };
	}


}
