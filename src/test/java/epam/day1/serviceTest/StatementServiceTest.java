package epam.day1.serviceTest;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.StatementService;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StatementServiceTest {

    StatementService service = new StatementService();

    @Test
    public void createListOfEvenNumbersPositiveTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(545);
        list.add(589);
        list.add(458);
        Response<List<Integer>> actual = service.createListOfEvenNumbers("123", "545", "589", "458");
        Response<List<Integer>> expected = new Response<>(Status.OK, ErrorCode.NONE, list);
        assertEquals(actual, expected);
    }

    @Test
    public void createListOfEvenNumbersNegativeValidationTest() {
        Response<List<Integer>> actual = service.createListOfEvenNumbers("1526", "366", "890", "-3");
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void createListOfEvenNumbersParsingTest() {
        Response<List<Integer>> actual = service.createListOfEvenNumbers("mkll", "hhjm", "256");
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void selectEvenNumbersTrueTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(124);
        list.add(542);
        list.add(584);
        Response<Boolean> actual = service.trueOrFalseStatement(list);
        Response<Boolean> expected = new Response<>(Status.OK, ErrorCode.NONE, true);
        assertEquals(actual, expected);
    }

    @Test
    public void selectEvenNumbersFalseTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(124);
        Response<Boolean> actual = service.trueOrFalseStatement(list);
        Response<Boolean> expected = new Response<>(Status.OK, ErrorCode.NONE, false);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberPositiveTest() {
        Response<Integer> actual = service.checkNumber("123");
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 123);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberNegativeValidationTest() {
        Response<Integer> actual = service.checkNumber("100245");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberNegativeParsingTest() {
        Response<Integer> actual = service.checkNumber("1002lki");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateSumOfDividersTest() {
        Response<Integer> actual = service.calculateSumOfDividers(6);
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 6);
        assertEquals(actual, expected);
    }

    @Test
    public void isPerfectNumberPositiveTest() {
        Response<Boolean> actual = service.isPerfectNumber(6, 6);
        Response<Boolean> expected = new Response<>(Status.OK, ErrorCode.NONE, true);
        assertEquals(actual, expected);
    }

    @Test
    public void isPerfectNumberNegativeTest() {
        Response<Boolean> actual = service.isPerfectNumber(8, 7);
        Response<Boolean> expected = new Response<>(Status.OK, ErrorCode.NONE, false);
        assertEquals(actual, expected);
    }

}
