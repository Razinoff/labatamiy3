package rofl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BeginStringFilterTest {
    @Test
    void testBeginStringFilterFirst() {
        String str = "Мама мыла раму";
        BeginStringFilter filter1 = new BeginStringFilter("Мама");
        assertTrue(filter1.apply(str), "Мама");
    }

    @Test
    void testBeginStringFilterSecond() {
        String str = "Мама мыла раму";
        BeginStringFilter filter2 = new BeginStringFilter("мыла");

        assertFalse(filter2.apply(str), "мыла");
    }
}
