package entity;

public class User {
   
    private int id;
    private String firstName;
    private String lastName;
    private String Address;
    private String city;
    private int zip;
    private String state;
    private String country;
    private String phone;
    private String email;
    private String password;
//constructore
    public User() {
   
}
    public User(int id, String firstName, String lastName, String address, String city, int zip, String state,
            String country, String phone, String email, String password) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    public User(String firstName, String lastName, String address, String city, int zip, String state, String country,
            String phone, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    //  getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
