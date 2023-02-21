import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;
    @Mock
    Feline feline;
    @Before
    public void createCat() {
        cat = new Cat(feline);
    }

    @Test
    public void catSoundCheck() {
        String expectedSound = "Мяу";
        assertEquals(expectedSound, cat.getSound());
    }
    @Test
    public void catGetsFood () throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoodList, cat.getFood());
    }
}
