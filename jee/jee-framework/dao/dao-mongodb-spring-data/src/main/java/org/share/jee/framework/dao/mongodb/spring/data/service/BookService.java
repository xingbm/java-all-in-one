package org.share.jee.framework.dao.mongodb.spring.data.service;

import org.share.jee.framework.dao.mongodb.spring.data.po.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ** created by DawnSailing at 2019/9/10
 *
 * @author DawnSailing
 */
@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存对象
     *
     * @param book
     * @return
     */
    public String saveObj(Book book) {
        mongoTemplate.save(book);
        return "添加成功";
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }

    /***
     * 根据id查询
     * @param id
     * @return
     */
    public Book getBookById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Book.class);
    }

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    public Book getBookByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Book.class);
    }

    public List<Book> findBookByPage(String name, int pageNum) {
        Criteria criteria = Criteria.where("name").in(name);
        Query query = Query.query(criteria);
        // 查询总数
        long totalCount = mongoTemplate.count(query, Book.class);
        // 每页个数
        int numOfPage = 10;
        // 计算总数
        long totalPage = totalCount%numOfPage==0?(totalCount/numOfPage):(totalCount/numOfPage+1);
        int skip = (pageNum -1) * numOfPage;
        query.skip(skip).limit(numOfPage);
        List<Book> bookList = mongoTemplate.find(query, Book.class);
        // TODO 构造一个Page对象，包含总数、当前页数，以及查询结果集
        return bookList;
    }

    /**
     * 更新对象
     *
     * @param book
     * @return
     */
    public String updateBook(Book book) {
        Query query = new Query(Criteria.where("_id").is(book.get_id()));
        Update update = new Update().set("publish", book.getPublish()).set("name", book.getName())
                .set("info", book.getInfo());
        mongoTemplate.updateFirst(query, update, Book.class);
        return "success";
    }

    /***
     * 删除对象
     * @param book
     * @return
     */
    public String deleteBook(Book book) {
        mongoTemplate.remove(book);
        return "success";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public String deleteBookById(String id) {
        //findOne
        Book book = getBookById(id);
        //delete
        deleteBook(book);
        return "success";
    }

}
