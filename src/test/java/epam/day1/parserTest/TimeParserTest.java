package epam.day1.parserTest;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.TimeParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TimeParserTest {

    TimeParser parser = new TimeParser();

    @Test
    public void parseStringDatePositiveTest() {
        String month = "january";
        try {
            int actual = parser.parseDate(month);
            int expected = 1;
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseDateNegativeTest() throws CustomException {
        String month = "jmh";
        parser.parseDate(month);
    }

    @Test
    public void parseIntDatePositiveTest() {
        String month = "1";
        try {
            int actual = parser.parseDate(month);
            int expected = 1;
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }
}
