import com.epam.fourth.interpreter.Client;
import com.epam.fourth.interpreter.DecrementHandler;
import com.epam.fourth.interpreter.IncrementHandler;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MathExpressionEvaluationTest {
    @Test
    public void calculationTest() {
        Client interpreter = new Client("6+9*(3-4)");
        assertEquals(interpreter.calculate(), -3);
    }

    @Test
    public void incrementTest() {
        assertEquals(4, Integer.parseInt(IncrementHandler.increment("3++")));
        assertEquals(4, Integer.parseInt(IncrementHandler.increment("++3")));
    }

    @Test
    public void decrementTest() {
        assertEquals(2, Integer.parseInt(DecrementHandler.decrement("3--")));
        assertEquals(2, Integer.parseInt(DecrementHandler.decrement("--3")));
    }


}
