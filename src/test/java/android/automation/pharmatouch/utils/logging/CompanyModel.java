package android.automation.pharmatouch.utils.logging;

/**
 * Created by massacre99 on 10.04.2018.
 */
public class CompanyModel {
    private String name;
    private String type;
    private String city;
    private String street;
    private String building;

    public CompanyModel(String name, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }


    public String getBuilding() {
        return building;
    }

    public void setType(String type) {
        this.type = type;
    }
}
