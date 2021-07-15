package beans;

public class Payment {
    private Double tax;
    private Double subTotal;
    private Product product;
    private Order order;

    public Payment() {
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
