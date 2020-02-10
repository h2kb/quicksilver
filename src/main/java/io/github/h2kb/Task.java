package io.github.h2kb;

import java.util.Date;

public class Task {

    private final int id;

    private final Date createDate;

    private final String client;

    public Task(int id, String client) {
        this.id = id;
        this.createDate = new Date();
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getClient() {
        return client;
    }
}
