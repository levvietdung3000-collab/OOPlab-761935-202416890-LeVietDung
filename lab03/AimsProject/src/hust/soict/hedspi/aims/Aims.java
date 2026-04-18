package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",87, 19.95f);
        anOrder.addDigitalVideoDisc(dv1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        //anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter", "Witch", 20.54f);
        // anOrder.addDigitalVideoDisc(dvd4);
        DigitalVideoDisc[] dvdArray ={dvd3, dvd4};
        anOrder.addDigitalVideoDisc(dvdArray);

        //display
        anOrder.print();

        //remove item from cart
        anOrder.removeDigitalVideoDisc(dvd4);
        anOrder.print();



        //Total cost
        System.out.println("Total cost is : " + anOrder.totalCost());
        //commit for pull
    }
}