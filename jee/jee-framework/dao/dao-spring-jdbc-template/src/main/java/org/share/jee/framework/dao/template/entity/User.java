package org.share.jee.framework.dao.template.entity;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * Created by xingbm on 2021/2/17 12:01
 */
public class User {

    private Integer id;

    private String name;

    private Integer departmentId;

    private LocalDate createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("departmentId=" + departmentId)
                .add("createTime=" + createTime)
                .toString();
    }

}
