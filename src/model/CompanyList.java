package model;

import java.util.ArrayList;
import java.util.List;

public class CompanyList {
    private List<Company> companySet;

    public CompanyList() {
        companySet = new ArrayList<>();
    }

    public void addCompany(Company c) {
        companySet.add(c);
    }

    public void removeCompany(String s) {
        for (Company c : companySet) {
            if (c.getCompanyName().equals(s)) {
                companySet.remove(c);
            }
        }
    }

    public List<Company> getCompanySet() {
        return companySet;
    }
}
