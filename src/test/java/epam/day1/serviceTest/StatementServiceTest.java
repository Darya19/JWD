package epam.day1.serviceTest;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.StatementService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class StatementServiceTest {

    StatementService service;
    List<Integer> actualPositiveList;
    List<Integer> expectedList;
    List<Integer> actualNegativeList;

    @BeforeClass
    public void setUp(){
        service = new StatementService();
        actualPositiveList = new ArrayList<>();
        actualPositiveList.add(123);
        actualPositiveList.add(545);
        actualPositiveList.add(589);
        actualPositiveList.add(458);
        expectedList = new ArrayList<>();
        expectedList.add(458);
        actualNegativeList = new ArrayList<Integer>();
        actualNegativeList.add(1230);
        actualNegativeList.add(545);
        actualNegativeList.add(5890);
        actualNegativeList.add(-458);
    }

    @Test
    public void createListOfEvenNumbersPositiveTest() {
        Response<List<Integer>> actual = service.createListOfEvenNumbers(actualPositiveList);
        Response<List<Integer>> expected = new Response<>(Status.OK, ErrorCode.NONE, expectedList);
        assertEquals(actual, expected);
    }

    @Test
    public void createListOfEvenNumbersNegativeTest() {
        Response<List<Integer>> actual = service.createListOfEvenNumbers(actualNegativeList);
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void selectEvenNumbersTrueTest() {
        List<Integer> list = new ArrayList<>();
        list.add(124);
        list.add(542);
        list.add(584);
        Response<Boolean> actual = service.trueOrFalseStatement(list);
        Response<Boolean> expected = new Response<>(Status.OK, ErrorCode.NONE, true);
        assertEquals(actual, expected);
    }

    @Test
    public void selectEvenNumbersFalseTest() {
        List<Integer> list = new ArrayList<>();
        list.add(124);
        Response<Boolean> actual = service.trueOrFalseStatement(list);
        Response<Boolean> expected = new Response<>(Status.OK, ErrorCode.NONE, false);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberPositiveTest() {
        Response<Integer> actual = service.checkNumber(123);
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 123);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberNegativeTest() {
        Response<Integer> actual = service.checkNumber(100245);
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
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
