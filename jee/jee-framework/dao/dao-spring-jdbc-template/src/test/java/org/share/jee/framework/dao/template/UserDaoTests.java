package org.share.jee.framework.dao.template;

import org.junit.jupiter.api.Test;
import org.share.jee.framework.dao.template.dao.UserDao;
import org.share.jee.framework.dao.template.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    void count() {
        System.out.println(userDao.count());
    }

    @Test
    void countWithParam() {
        System.out.println(userDao.countWithParam(1));
    }

    @Test
    void getUser() {
        System.out.println(userDao.getUser(1));
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1);
        user.setName("哈哈哈哈哈哈");
        user.setDepartmentId(1);
        user.setCreateTime(LocalDate.now());
        System.out.println(userDao.update(user));
    }

    @Test
    void insert() {
        User user = new User();
        user.setId(1);
        user.setName("哈哈哈哈哈");
        user.setDepartmentId(1);
        user.setCreateTime(LocalDate.now());
        System.out.println(userDao.insert(user));
    }

}
