import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.chain.BasicBreaker;
import com.epam.fourth.chain.TextBreaker;
import com.epam.fourth.composite.Component;
import org.junit.Before;
import org.junit.Test;

public class TextManipulationTest {
    private TextManipulation textManipulation;
    private Component textComposite;

    @Before
    public void createTextManipulation() {
        textManipulation = new TextManipulation();
        String text = "So close. No matter how far.";
        BasicBreaker breaker = new TextBreaker();
        textComposite = breaker.breakText(text);
    }

    @Test
    public void sentenceOrderTest() {
        textManipulation.printOrderedSentences(textComposite);
    }

    @Test
    public void firstAndLastSwapTest() {
        textManipulation.swapFistAndLastLexeme(textComposite);
        System.out.println(textComposite);
    }

    @Test
    public void removeLexemeTest() {
        textManipulation.removeCertainLexeme(textComposite, 2, "n");
        System.out.println(textComposite);
    }
}
