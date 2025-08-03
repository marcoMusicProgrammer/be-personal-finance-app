package com.personal.app.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="income")
public class Income extends BaseEntity {

    String description;
    double amount;
    LocalDate date;

    public Income(){};
    public Income(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Income: description=" + description + ", amount=" + amount + ", date=" + date + "\n";
    }
    
    
}
