package org.share.jee.framework.dao.mongodb.spring.data;

import org.junit.jupiter.api.Test;
import org.share.jee.framework.dao.mongodb.spring.data.po.Book;
import org.share.jee.framework.dao.mongodb.spring.data.service.BookService;
import org.share.jee.framework.dao.mongodb.spring.data.service.MongoDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by xingbm on 2021/2/16 14:32
 */
@SpringBootTest
public class MongoDriverServiceTests {

    @Autowired
    private BookService bookService;
    @Autowired
    private MongoDriverService mongoDriverService;

    @Test
    public void findBook() {
        List<Book> bookList = bookService.findAll();
        if (bookList == null || bookList.isEmpty()) {
            return;
        }
        mongoDriverService.findBook(bookList.get(0).get_id());
    }

}
