package rofl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuperEqualsTest {
    @Test
    void testBeginStringFilterFirst() {
        String str = "egor";
        SuperEquals filter1 = new SuperEquals("EGOR");
        assertTrue(filter1.apply(str), "EGOR");
    }

    void testBeginStringFilterSecond() {
        String str = "egor";
        SuperEquals filter1 = new SuperEquals ("Egor");
        assertFalse(filter1.apply(str), "Egor");
    }
}
