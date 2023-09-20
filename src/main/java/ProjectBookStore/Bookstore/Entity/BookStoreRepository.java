package ProjectBookStore.Bookstore.Entity;

import org.springframework.data.repository.CrudRepository;

public interface BookStoreRepository extends CrudRepository<Book, Long> {
	
}
