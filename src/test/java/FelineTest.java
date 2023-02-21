import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private Feline feline;

    @Before
    public void createFeline() {
        feline = new Feline();
    }

    @Test
    public void felineGetsFamily() {
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, feline.getFamily());
    }

    @Test
    public void felineGetsKittens() {
        int expectedCountKittens = 1;
        assertEquals(expectedCountKittens, feline.getKittens());
    }

    @Test
    public void felineReturnKittensCountNegative() {
        int expectedCountKittens = 2;
        int kittensCount = 3;
        assertNotEquals(expectedCountKittens, feline.getKittens(kittensCount));
    }

    @Test
    public void felineEatsMeat() throws Exception {
        List<String> expectedListFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedListFood, feline.eatMeat());
    }
}
