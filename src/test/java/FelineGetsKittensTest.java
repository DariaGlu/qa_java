import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetsKittensTest {
    private final int kittensCount;
    private final int expectedKittens;

    public FelineGetsKittensTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters(name = "Test data: givenKittens: {0}, expectedKittens :{1}")
    public static Object[][] getData() {
        return new Object[][] {
                {1, 1},
                {25, 25},
        };
    }

    @Test
    public void felineReturnKittensCountPositive() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(kittensCount));
    }
}
