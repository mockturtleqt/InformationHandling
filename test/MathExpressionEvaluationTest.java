import com.epam.fourth.action.InfixToPostfixConverter;
import com.epam.fourth.interpreter.Client;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MathExpressionEvaluationTest {
    @Test
    public void calculationTest() {
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        converter.convertExpression("6+9*(3-4)");
        Client interpreter = new Client(converter.getPostfix());
        assertEquals(interpreter.calculate(), -3);
    }
}
