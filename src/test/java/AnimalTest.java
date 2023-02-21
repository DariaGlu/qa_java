import com.example.Animal;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private static final String unexpectedAnimalKind = "Всеядное";
    private static final String families = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private Animal animal;
    @Before
    public void createAnimal() {
        animal = new Animal();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void exceptionWhenAnimalGetsFood() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        animal.getFood(unexpectedAnimalKind);
    }

    @Test
    public void animalGetsFamily() {
      assertEquals(families, animal.getFamily());
    }
}
