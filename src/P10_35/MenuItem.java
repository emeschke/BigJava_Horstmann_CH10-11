package P10_35;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/30/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuItem {
    private String name;
    private double price;
    private int count = 0;


    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
