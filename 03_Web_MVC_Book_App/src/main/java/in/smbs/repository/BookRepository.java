package in.smbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.smbs.entity.Book;

public interface BookRepository 
		extends JpaRepository<Book, Integer>{

}
