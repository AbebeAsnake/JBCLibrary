package me.abebe.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddBookRepository extends CrudRepository<AddBook,Long> {
    List<AddBook> findAddBookByState(String state);
}
