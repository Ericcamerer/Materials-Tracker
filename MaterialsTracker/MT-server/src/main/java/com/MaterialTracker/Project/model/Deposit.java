package com.MaterialTracker.Project.model;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class Deposit {

    private int id;
    private int depositor_id;
    private LocalDate date;
    private String material_type;
    private String wood_type;
    private int hardware_weight;
    private int deposit_weight;
    private String donor_name;
    private int status;

    public Deposit(int id, int depositor_id, LocalDate date, String material_type, String wood_type, int hardware_weight, int deposit_weight, String donor_name, int status) {
        this.id = id;
        this.depositor_id = depositor_id;
        this.date = date;
        this.material_type = material_type;
        this.wood_type = wood_type;
        this.hardware_weight = hardware_weight;
        this.deposit_weight = deposit_weight;
        this.donor_name = donor_name;
        this.status = status;
    }



    public Deposit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepositor_id() {
        return depositor_id;
    }

    public void setDepositor_id(int depositor_id) {
        this.depositor_id = depositor_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(String material_type) {
        this.material_type = material_type;
    }

    public String getWood_type() {
        return wood_type;
    }

    public void setWood_type(String wood_type) {
        this.wood_type = wood_type;
    }

    public int getHardware_weight() {
        return hardware_weight;
    }

    public void setHardware_weight(int hardware_weight) {
        this.hardware_weight = hardware_weight;
    }

    public int getDeposit_weight() {
        return deposit_weight;
    }

    public void setDeposit_weight(int deposit_weight) {
        this.deposit_weight = deposit_weight;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


