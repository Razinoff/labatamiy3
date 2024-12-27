package rofl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EqualsITest {
    @Test
    void testBeginStringFilterFirst() {
        String str = "Мама";
        EqualsI filter1 = new EqualsI("Мама");
        assertTrue(filter1.apply(str), "Мама");
    }

    void testBeginStringFilterSecond() {
        String str = "Egor Krid";
        EqualsI filter1 = new EqualsI("Мама");
        assertFalse(filter1.apply(str), "Мама");
    }
}
