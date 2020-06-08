package epam.day1.validatorTest;

import com.epam.day1.validator.NumberValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class NumberValidatorTest {
    NumberValidator validator = new NumberValidator();

    @Test
    public void validateNumberTrueTest() {
        assertTrue(validator.validateNumber(123.5));
    }

    @Test
    public void validateNumberFalseTest() {
        assertFalse(validator.validateNumber(1230266.588));
    }

    @Test
    public void checkEvenNumberFalseTest() {
        assertFalse(validator.checkEvenNumber(123));
    }

    @Test
    public void checkEvenNumberTrueTest() {
        assertTrue(validator.checkEvenNumber(12));
    }

}
