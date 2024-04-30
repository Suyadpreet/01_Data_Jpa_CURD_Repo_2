package com.suyad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.suyad.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>
{
	public Book findByBookNameLike(String pattern);
	
	public Book findByupdatedDateIsNotNull();
	
	public List<Book> findByBookNameOrderByBookpriceAsc(String name);
	
	@Query(value = "From Book where bookName = :name")
	public Book myMethod(String name);
	
	@Transactional
	@Modifying
	@Query(value = "update Book set bookprice = :p where boodId = :id")
	public void myMethodUpdate(Long p,Integer id);
	
	@Query(value = "select * from book where book_name = :n",nativeQuery = true)
	public Book nativeMethod(@Param("n")String name);
	
	@Transactional
	@Modifying
	@Query(value = "update book set bookprice = :p where bood_id = :id ",nativeQuery = true)
	public void nativeUpdate(Long p,Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "insert into book (bood_id,book_name,bookprice) values(:id,:name,:price)",nativeQuery = true)
	public void nativeAdd(Integer id,String name,Long price);
}
