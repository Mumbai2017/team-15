package trackOrder;

/**
 * Created by Admin on 7/29/2017.
 */

public class Order {
    int id;
    String ExpectedDate;
    int total;

    public Order(int id, String expectedDate, int total) {
        this.id = id;
        ExpectedDate = expectedDate;
        this.total = total;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpectedDate() {
        return ExpectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        ExpectedDate = expectedDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
