package model;

/**
 * Represents a Company:
 *       - companyName: Name of the Company
 *       - location: Location of Company
 *       - status:
 *           true -> got accepted
 *           false -> pending/waiting on response
 ***/
public class Company {
    private String companyName;
    private String location;
    private Boolean status;

    // Constructs a Company with name, location, and status
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
