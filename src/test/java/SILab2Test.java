import mk.ukim.finki.Item;
import mk.ukim.finki.SILab2;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    // Тест 1: Every Statement Coverage
    @Test
    public void test_EveryStatement() {
        // item без попуст
        Item item = new Item("Milk", 2, 100, 0.0);
        String cardNumber = "1234567890123456";

        double expected = 200.0;
        double actual = SILab2.checkCart(List.of(item), cardNumber);

        assertEquals(expected, actual);
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
}
