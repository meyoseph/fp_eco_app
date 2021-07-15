package beans;

public class Customer extends Role{
    private String email;

    public Customer(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
