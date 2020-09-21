package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gia Dat on 9/14/2020
 */
public class Company {
    private String name;
    private String description;

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Company> getData()
    {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Apple","Steve Jobs"));
        companies.add(new Company("Microsoft","Bill Gates"));
        companies.add(new Company("Telsa","Elon Musk"));
        return companies;
    }
}

