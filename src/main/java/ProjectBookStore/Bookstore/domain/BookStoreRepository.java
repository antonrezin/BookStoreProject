package ProjectBookStore.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookStoreRepository extends CrudRepository<Book, Long> {
	
}
