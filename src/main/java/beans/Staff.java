package beans;

public class Staff extends Role{

    private Staff manager;
    private Shop shop;

    public Staff(){}

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
