package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a List of Companies
 ***/
public class CompanyList {
    private List<Company> companySet;

    // Constructs company tracklist
    public CompanyList() {
        companySet = new ArrayList<>();
    }

    public void addCompany(Company c) {
        companySet.add(c);
    }

    public void removeCompany(Company c) {
        companySet.remove(c);
    }

    public List<Company> getCompanyList() {
        return companySet;
    }
}
