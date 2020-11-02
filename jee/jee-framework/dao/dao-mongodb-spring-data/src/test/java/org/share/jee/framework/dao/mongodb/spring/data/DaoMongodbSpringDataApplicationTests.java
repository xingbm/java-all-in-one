package org.share.jee.framework.dao.mongodb.spring.data;

import org.junit.jupiter.api.Test;
import org.share.jee.framework.dao.mongodb.spring.data.po.Book;
import org.share.jee.framework.dao.mongodb.spring.data.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DaoMongodbSpringDataApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MongoDbService mongoDbService;

    @Test
    public void saveObj() {
        Book book = new Book();
        book.setPrice(1);
        book.setName("大灰狼");
        mongoDbService.saveObj(book);
    }

    @Test
    public void findAll() {
        mongoDbService.findAll();
    }

    @Test
    public void findOne() {
        mongoDbService.getBookById("1");
    }

    @Test
    public void findOneByName() {
        mongoDbService.getBookByName("大灰狼");
    }

    @Test
    public void update() {
        Book book = new Book();
        book.setName("小灰狼");
        mongoDbService.updateBook(book);
    }

    @Test
    public void delOne() {
        Book book = new Book();
        mongoDbService.deleteBook(book);
    }

    @Test
    public void delById() {
        mongoDbService.deleteBookById("1");
    }

}
