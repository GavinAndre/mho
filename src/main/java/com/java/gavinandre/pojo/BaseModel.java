package com.java.gavinandre.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gavinandre on 17-1-12.
 */
public class BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -459530011111182045L;

    protected Long id;

    protected Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
