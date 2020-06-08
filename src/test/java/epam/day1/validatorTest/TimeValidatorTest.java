package epam.day1.validatorTest;

import com.epam.day1.validator.TimeValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class TimeValidatorTest {
    TimeValidator validator = new TimeValidator();

    @Test
    public void validateMonthFalseTest() {
        boolean condition = validator.validateMonth(13);
        assertFalse(condition);
    }

    @Test
    public void validateMonthTrueTest() {
        boolean condition = validator.validateMonth(11);
        assertTrue(condition);
    }

    @Test
    public void validateYearTrueTest() {
        boolean condition = validator.validateYear(2020);
        assertTrue(condition);
    }

    @Test
    public void validateYearFalseTest() {
        boolean condition = validator.validateYear(-3);
        assertFalse(condition);
    }

    @Test
    public void validateNumberOfSecondsFalseTest() {
        boolean condition = validator.validateNumberOfSeconds(136000);
        assertFalse(condition);
    }

    @Test
    public void validateNumberOfSecondsTrueTest() {
        boolean condition = validator.validateNumberOfSeconds(80000);
        assertTrue(condition);
    }
}
