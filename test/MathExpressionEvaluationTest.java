import com.epam.fourth.interpreter.InfixToPostfixConverter;
import com.epam.fourth.interpreter.Client;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MathExpressionEvaluationTest {
    @Test
    public void calculationTest() {
        Client interpreter = new Client("6+9*(3-4)");
        assertEquals(interpreter.calculate(), -3);
    }
}
