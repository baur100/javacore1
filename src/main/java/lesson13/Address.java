package lesson13;

public class Address {
    private PersonalName name;
    private String streetAddress;
    private String state;
    private int zip;
    private String city;

    public Address(PersonalName pn, String streetAddress,String city,String state,int zip){
        this.name=pn;
        this.streetAddress=streetAddress;
        this.city=city;
        this.zip=zip;
        this.state=state;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

    public PersonalName getName() {
        return name;
    }

}
