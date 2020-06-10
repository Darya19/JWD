package epam.day1.parserTest;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class NumberParserTest {

    NumberParser parser = new NumberParser();

    @Test
    public void parseToIntPositiveTest() {
        String number = "1258";
        try {
            int actual = parser.parseToInt(number);
            int expected = 1258;
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseToIntNegativeTest() throws CustomException{
        String number = "jmh";
        parser.parseToInt(number);
    }

    @Test
    public void parseToDoublePositiveTest() {
        String number = "1258";
        try {
            double actual = parser.parseToDouble(number);
            double expected = 1258;
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseToDoubleNegativeTest() throws CustomException{
        String number = "12a";
        parser.parseToDouble(number);
    }
}
