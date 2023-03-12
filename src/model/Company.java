package model;

public class Company {
    private String companyName;
    private String location;
    private Boolean status;

    public Company(String companyName, String location, boolean status) {
        this.companyName = companyName;
        this.location = location;
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
