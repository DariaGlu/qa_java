import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalGetsFoodTest {
    private final String animalKind;
    private final List<String> animalFoodList;
    private Animal animal;
    public AnimalGetsFoodTest(String animalKind, List<String> animalFoodList) {
        this.animalKind = animalKind;
        this.animalFoodList = animalFoodList;
    }

    @Parameterized.Parameters(name = "Test data: {0} eats {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Before
    public void createAnimal() {
        animal = new Animal();
    }

    @Test
    public void animalGetsFood() throws Exception {
        assertEquals(animalFoodList, animal.getFood(animalKind));
    }
}
