package epam.day1.parserTest;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.ListOfNumbersParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ListOfNumbersParserTest {

    ListOfNumbersParser parser;
    List<Integer> expectedList;

    @BeforeClass
    public void setUp() {
        parser = new ListOfNumbersParser();
        expectedList = new ArrayList<>();
        expectedList.add(123);
        expectedList.add(545);
        expectedList.add(187);
        expectedList.add(456);
    }

    @Test
    public void parseToIntListPositiveTest() {
        try {
            List<Integer> actualList = parser.parseToIntList("123", "545", "187", "456");
            assertEquals(actualList, expectedList);
        } catch (CustomException e) {
            System.out.println("error");
            ;
        }
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseToIntListNegativeTest() throws CustomException {
        parser.parseToIntList("123hj", "545hh", "187", "456");
    }
}
