import mk.ukim.finki.Item;
import mk.ukim.finki.SILab2;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

   // Тест 1: Every Statement Coverage
    @Test
    void testInvalidCardCharacter() {
        List<Item> items = List.of(new Item("abc", 3, 299, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "0123456789aaa456");
        });
        assertEquals("Invalid character in card number!", ex.getMessage());
    }

    // Тест 2: Multiple Condition Coverage
    @Test
    public void test_MultipleCondition() {
        // TC5: price > 300, discount > 0 → -30 се одзема
        Item item = new Item("Laptop", 2, 400, 0.2);
        String cardNumber = "1234567890123456";

        double expected = -30 + 400 * (1 - 0.2) * 2;
        double actual = SILab2.checkCart(List.of(item), cardNumber);

        assertEquals(expected, actual);
    }
    //    @Test
//    void testNullItemList() {
//        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
//            SILab2.checkCart(null, "0123456789123456");
//        });
//        assertEquals("allItems list can't be null!", ex.getMessage());
//    }
//
//    @Test
//    void testItemWithNullName() {
//        List<Item> items = List.of(new Item(null, 1, 100, 0));
//        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
//            SILab2.checkCart(items, "0123456789123456");
//        });
//        assertEquals("Invalid item!", ex.getMessage());
//    }
//
//
//    @Test
//    void testInvalidCardCharacter() {
//        List<Item> items = List.of(new Item("abc", 3, 299, 0));
//        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
//            SILab2.checkCart(items, "0123456789aaa456");
//        });
//        assertEquals("Invalid character in card number!", ex.getMessage());
//    }
//
//
//    @Test
//    void testNullCardNumber() {
//        List<Item> items = List.of(new Item("abc", 3, 299, 0));
//        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
//            SILab2.checkCart(items, null);
//        });
//        assertEquals("Invalid card number!", ex.getMessage());
//    }
//
//
//    @Test
//    void testItemWithDiscountAndPriceAboveThreshold() {
//        List<Item> items = List.of(new Item("abc", 3, 301, 0.1)); // triggers discount & price > 300
//        double expected = -30 + (301 * (1 - 0.1) * 3);
//        double actual = SILab2.checkCart(items, "0123456789123456");
//        assertEquals(expected, actual);
//    }
}


