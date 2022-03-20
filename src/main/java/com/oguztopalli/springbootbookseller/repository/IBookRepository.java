package com.oguztopalli.springbootbookseller.repository;

import com.oguztopalli.springbootbookseller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {


}
