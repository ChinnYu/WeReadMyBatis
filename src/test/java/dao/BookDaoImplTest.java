package dao;

import com.jason.dao.BookDao;
import com.jason.dao.BookDaoImpl;
import com.jason.model.Book;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

/** 
* BookDaoImpl Tester. 
* 
* @author Liu 
* @since <pre>08/12/2018</pre> 
* @version 1.0 
*/ 
public class BookDaoImplTest {
    BookDao dao;
@Before
public void before() throws Exception {
    dao = new BookDaoImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getBookById(int id) 
* 
*/ 
@Test
public void testGetBookById() throws Exception {
    System.out.println(dao.getBookById(7));
} 

/** 
* 
* Method: getAllBooks() 
* 
*/ 
@Test
public void testGetAllBooks() throws Exception {
    for (Book book: dao.getAllBooks()) {
        System.out.println(book);
    }
} 

/** 
* 
* Method: add(Book book) 
* 
*/ 
@Test
public void testAdd() throws Exception {
    Book book = new Book();
    book.setBook_typename("電腦");
    book.setBook_state("未借出");
    book.setBook_title("springMVC");
    book.setBook_price(25);
    Assert.assertEquals(1,dao.add(book));
} 

/** 
* 
* Method: update(Book book) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Book book = dao.getBookById(17);
    book.setBook_typename("電腦");
    book.setBook_state("未借出");
    book.setBook_title("springMVCddd");
    book.setBook_price(25);
    Assert.assertEquals(1,dao.update(book));
} 

/** 
* 
* Method: deleteById(int id) 
* 
*/ 
@Test
public void testDeleteById() throws Exception {
    Assert.assertEquals(1,dao.deleteById(17));
} 


} 
