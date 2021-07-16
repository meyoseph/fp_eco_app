package beans;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private LocalDateTime dateTime;
    private Payment payment;
    private List<Staff> staff;

    public Order() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
