package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "labor_datas")
public class LaborData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_profile")
    private String jobProfile;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "salary_range")
    private String salaryRange;

    private String activities;
    private String NSS;
    private String currency;

    public LaborData() {
    }

    public LaborData(String jobProfile, String bankAccount, String salaryRange, String activities, String nSS,
            String currency) {
        this.jobProfile = jobProfile;
        this.bankAccount = bankAccount;
        this.salaryRange = salaryRange;
        this.activities = activities;
        NSS = nSS;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String nSS) {
        NSS = nSS;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
