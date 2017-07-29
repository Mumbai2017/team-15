package orderPlace;

/**
 * Created by Admin on 7/29/2017.
 */

public class Item {

    String name;
    int price;
    int quantity;

    public Item(String name, int price, int quantity, int total) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateprice();
    }
    void updateprice(){
        total=price*quantity;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    int total;

    public  Item(){

    }


}
