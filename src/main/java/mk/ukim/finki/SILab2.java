package mk.ukim.finki;
import java.util.List;


public class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){ //A
            throw new RuntimeException("allItems list can't be null!"); //B
        }

        double sum = 0;

        for (int i = 0; i < allItems.size(); i++){ //C
            Item item = allItems.get(i);
            if (item.getName() == null || item.getName().length() == 0){ //D
                throw new RuntimeException("Invalid item!"); //E
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){ //F
                sum -= 30; //G
            }

            if (item.getDiscount() > 0){ //H
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity(); //I
            }
            else {
                sum += item.getPrice()*item.getQuantity(); //J
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) { //K
            String allowed = "0123456789";
            char[] chars = cardNumber.toCharArray();
            for (int j = 0; j < cardNumber.length(); j++) { //L
                char c = cardNumber.charAt(j);
                if (allowed.indexOf(c) == -1) { //M
                    throw new RuntimeException("Invalid character in card number!"); //N
                }
            }
        }
        else{ //O
            throw new RuntimeException("Invalid card number!");
        }

        return sum;

    }
}