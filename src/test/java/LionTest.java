import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String OTHER = "Кто-то";

    @Mock
    Feline feline;

    @Test
    public void lionGetsKittens() throws Exception {
        Lion lion = new Lion(FEMALE, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        assertEquals(expectedKittens, lion.getKittens());
    }

    @Test
    public void lionGetsFood () throws Exception {
        Lion lion = new Lion(MALE, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoodList, lion.getFood());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void exceptionWhenLionCreation() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion(OTHER, feline);
    }
}
