package org.share.jee.framework.dao.mongodb.spring.data.service;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.share.jee.framework.dao.mongodb.spring.data.po.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by xingbm on 2021/2/16 14:10
 */
@Service
public class MongoDriverService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Book findBook(String _id) {
        Book book = mongoTemplate.execute(new DbCallback<Book>() {
            @Override
            public Book doInDB(MongoDatabase db) throws MongoException, DataAccessException {
                // 获得集合
                MongoCollection<Document> collection = db.getCollection("book");
                // 查找文档
                Document doc = collection.find(new Document("_id", _id)).first();
                // 将Document对象转化成Book对象
                Book book = new Book();
                book.setName(doc.getString("name"));
                book.setInfo(doc.getString("info"));
                book.setPublish(doc.getString("publish"));
                book.setPrice(new BigDecimal(doc.getString("price")));
                return book;
            }
        });
        return  book;
    }

}
