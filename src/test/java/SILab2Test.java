import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyStatementTest() {
        RuntimeException ex1 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(null, "1111111111111111"));
        assertEquals("allItems list can't be null!", ex1.getMessage());


        Item item1 = new Item(null, 1, 100, 0);
        RuntimeException ex2 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(List.of(item1), "1111111111111111"));
        assertEquals("Invalid item!", ex2.getMessage());


        Item item2 = new Item("Milk", 3, 100, 0);
        RuntimeException ex3 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(List.of(item2), "1111"));
        assertEquals("Invalid card number!", ex3.getMessage());


        RuntimeException ex4 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(List.of(item2), "1B11111111111111"));
        assertEquals("Invalid character in card number!", ex4.getMessage());


        Item item3 = new Item("item", 12, 350, 0.1);
        double result = SILab2.checkCart(List.of(item3), "1111111111111111");
        assertEquals(3750.0, result);
    }

    @Test
    void multipleConditionTest() {
        String card = "1111111111111111";


        Item i1 = new Item("item",4 , 100, 0);
        assertEquals(400, SILab2.checkCart(List.of(i1), card));


        Item i2 = new Item("item", 4, 450, 0);
        assertEquals(1770, SILab2.checkCart(List.of(i2), card));


        Item i3 = new Item("item", 4, 100, 0.2);
        assertEquals(290, SILab2.checkCart(List.of(i3), card));


        Item i4 = new Item("item", 11, 100, 0);
        assertEquals(1070, SILab2.checkCart(List.of(i4), card));
    }
}
