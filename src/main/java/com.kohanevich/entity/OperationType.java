package com.kohanevich.entity;

/**
 * Created by Denis on 6/12/2016
 */
public enum OperationType {
    WITHDRAW(1), INFO(2);

    private int id;

    OperationType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
