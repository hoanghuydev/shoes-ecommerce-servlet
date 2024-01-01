package com.ltweb_servlet_ecommerce.model;

import java.sql.Timestamp;
import java.util.List;

public class AbstractModel<T> {
    private Long id;
    private Timestamp createAt;
    private Timestamp updateAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

}
