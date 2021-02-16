package org.share.jee.framework.dao.mongodb.spring.data;

import org.junit.jupiter.api.Test;
import org.share.jee.framework.dao.mongodb.spring.data.po.Book;
import org.share.jee.framework.dao.mongodb.spring.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class BookServiceTests {

    @Autowired
    private BookService bookService;

    @Test
    public void saveObj() {
        Book book = new Book();
        book.setName("马大哈");
        book.setInfo("哈哈哈哈哈");
        book.setPublish("新华社");
        book.setPrice(new BigDecimal("100.00"));
        bookService.saveObj(book);
    }

    @Test
    public void findAll() {
        System.out.println(bookService.findAll());
    }

    @Test
    public void findOne() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        System.out.println(bookService.getBookById(bookList.get(0).get_id()));
    }

    @Test
    public void findOneByName() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        System.out.println(bookService.getBookByName(bookList.get(0).getName()));
    }

    @Test
    public void findBookByPage() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        System.out.println(bookService.findBookByPage(bookList.get(0).getName(), 1));
    }

    @Test
    public void update() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        Book book = bookList.get(0);
        book.setName("小灰狼");
        bookService.updateBook(book);
    }

    @Test
    public void delOne() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        bookService.deleteBook(bookList.get(0));
    }

    @Test
    public void delById() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        bookService.deleteBookById(bookList.get(0).get_id());
    }

}
