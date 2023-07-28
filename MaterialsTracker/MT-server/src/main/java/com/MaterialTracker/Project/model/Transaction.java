package com.MaterialTracker.Project.model;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class Transaction {

    private int id;
    private LocalDate date;
    @Positive(message = "Amount must be greater than zero")
    private int amount;
    private int to_id;
    private int from_id;
    private int status;

    public Transaction(int id, LocalDate date, int amount, int to_id, int from_id, int status) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.to_id = to_id;
        this.from_id = from_id;
        this.status = status;
    }

    public Transaction() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTo_id() {
        return to_id;
    }

    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }

    public int getFrom_id() {
        return from_id;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


