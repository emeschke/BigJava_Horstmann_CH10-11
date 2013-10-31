package P10_35;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/30/13
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestaurantBill {
    private JButton cokeButton;
    private JButton spriteButton;
    private javax.swing.JPanel jPanel;
    private JButton coffeeButton;
    private JButton hotTeaButton;
    private JButton icedTeaButton;
    private JButton rootBeerButton;
    private JButton cookieButton;
    private JButton cakeButton;
    private JButton pieButton;
    private JButton iceCreamButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton calculateBillButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order entry");
        frame.setContentPane(new RestaurantBill().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,800);
        frame.setVisible(true);

        }



    public RestaurantBill(){
        final ArrayList<MenuItem> menuBill = addItems();

        //A class is declared that adds one to the correct class in menuBill when an action event is triggered,
        //the object that stores the menu and number of each purchased.

        class MenuListener implements ActionListener{
            int choice;
            public MenuListener(int buttonNum){
                choice = buttonNum;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBill.get(choice).setCount(menuBill.get(choice).getCount() + 1);
            }
        }

        //Here each menu item has a listener attached which will increment its count in the ArrayList of MenuItems
        //when the button is clicked.
        ActionListener cokeL = new MenuListener(0);
        cokeButton.addActionListener(cokeL);

        ActionListener spriteL = new MenuListener(1);
        spriteButton.addActionListener(spriteL);

        ActionListener coffeeL = new MenuListener(2);
        coffeeButton.addActionListener(coffeeL);

        ActionListener hotTeaButtonL = new MenuListener(3);
        hotTeaButton.addActionListener(hotTeaButtonL);

        ActionListener icedTeaButtonL = new MenuListener(4);
        icedTeaButton.addActionListener(icedTeaButtonL);

        ActionListener rootBeerL = new MenuListener(5);
        rootBeerButton.addActionListener(rootBeerL);

        ActionListener cookieL = new MenuListener(6);
        cookieButton.addActionListener(cookieL);

        ActionListener cakeL = new MenuListener(7);
        cakeButton.addActionListener(cakeL);

        ActionListener pieL = new MenuListener(8);
        pieButton.addActionListener(pieL);

        ActionListener iceCreamL = new MenuListener(9);
        iceCreamButton.addActionListener(iceCreamL);

        //An inner class to read in the two text fields.  It will then check that the price is a valid double value.
        //If it is not reasonable (0<price<100) it will assign the NaN to the price.  It will then enter the price
        //in the ArrayList as a one-off purchase if the inputs are valid.






        //An inner class is declared for the button that calculates the total bill.  Its action performed is to
        //print all of the purchases by number and then price, and then print sub-total, tax, tip and total in the
        //text area.  Couldn't figure out how to get the formatting correct on the decimal places.
        class BillListener implements ActionListener{
            double totalBill = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("\n");
                for (int i = 0; i < menuBill.size(); i++) {
                    textArea1.append(menuBill.get(i).getName() + " x" + menuBill.get(i).getCount() + " $" +
                    menuBill.get(i).getCount()*menuBill.get(i).getPrice()+ "\n");
                    totalBill += menuBill.get(i).getCount()*menuBill.get(i).getPrice();
                }
                textArea1.append("Food and drink total is: $" + String.format("%.2g%n", totalBill));
                textArea1.append("\nTax: $" + totalBill*.1);
                textArea1.append("\nTip: $" + totalBill*.15);
                textArea1.append("\nYou owe: $" + totalBill*1.25);
            }
        }

        //Attach the action listener to the button that calculates the total.
        ActionListener billButtonL = new BillListener();
        calculateBillButton.addActionListener(billButtonL);


    }

     //Method to add items that correspond with the buttons and return an array of menu items.
     public static ArrayList<MenuItem> addItems(){
         ArrayList<MenuItem> menuBill = new ArrayList<MenuItem>();
         MenuItem coke = new MenuItem("Coke" , 2.25);
         MenuItem sprite = new MenuItem("Sprite" , 2.25);
         MenuItem coffee = new MenuItem("Coffee" , 1.70);
         MenuItem hotTea = new MenuItem("Tea" , 2.00);
         MenuItem icedTea = new MenuItem("Iced Tea" , 3.00);
         MenuItem rootBeer = new MenuItem("Root Beer" , 3.50);
         MenuItem cookie = new MenuItem("Cookie" , 2.50);
         MenuItem cake = new MenuItem("Cake" , 4.50);
         MenuItem pie = new MenuItem("Pie" , 4.50);
         MenuItem iceCream = new MenuItem("Ice Cream" , 4.50);
         menuBill.add(coke);
         menuBill.add(sprite);
         menuBill.add(coffee);
         menuBill.add(hotTea);
         menuBill.add(icedTea);
         menuBill.add(rootBeer);
         menuBill.add(cookie);
         menuBill.add(cake);
         menuBill.add(pie);
         menuBill.add(iceCream);
         return menuBill;
     }





}
