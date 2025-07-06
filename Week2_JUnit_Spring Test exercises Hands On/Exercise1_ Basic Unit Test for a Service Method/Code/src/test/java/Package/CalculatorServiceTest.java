package Package;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.add(10, 20);
        assertEquals(30, result, "Addition should return 30 as a sum...");
    }
}

