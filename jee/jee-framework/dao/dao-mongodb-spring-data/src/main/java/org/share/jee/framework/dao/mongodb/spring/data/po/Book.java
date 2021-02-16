package org.share.jee.framework.dao.mongodb.spring.data.po;

import java.math.BigDecimal;

/**
 * ** created by DawnSailing at 2019/9/10
 *
 * @author DawnSailing
 */
public class Book {

    private String _id;

    /**
     * 书名
     */
    private String name;
    /**
     * 简介
     */
    private String info;
    /**
     * 出版社
     */
    private String publish;
    /**
     * 价格
     */
    private BigDecimal price;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
