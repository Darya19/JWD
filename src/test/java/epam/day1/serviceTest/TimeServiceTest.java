package epam.day1.serviceTest;

import com.epam.day1.entity.Day;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.TimeService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TimeServiceTest {

    TimeService service = new TimeService();

    @Test
    public void checkMonthByNumberPositiveTest() {
        Response<Integer> actual = service.checkMonth("12");
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 12);
        assertEquals(actual, expected);
    }

    @Test
    public void checkMonthByNamePositiveTest() {
        Response<Integer> actual = service.checkMonth("april");
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 4);
        assertEquals(actual, expected);
    }

    @Test
    public void checkMonthByNameNegativeParsingTest() {
        Response<Integer> actual = service.checkMonth("father");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkMonthByNumberNegativeValidationTest() {
        Response<Integer> actual = service.checkMonth("144");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkYearPositiveTest() {
        Response<Integer> actual = service.checkYear("2020");
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 2020);
        assertEquals(actual, expected);
    }

    @Test
    public void checkYearNegativeValidationTest() {
        Response<Integer> actual = service.checkYear("-550");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkYearNegativeParsingTest() {
        Response<Integer> actual = service.checkYear("12lkj");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void getNumberOfDaysTest() {
        Response<Integer> actual = service.getNumberOfDays(2020, 2);
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 29);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberOfSecondsPositiveTest() {
        Response<Integer> actual = service.checkNumberOfSeconds("4862");
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 4862);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberOfSecondsNegativeValidationTest() {
        Response<Integer> actual = service.checkYear("90000");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberOfSecondsNegativeParsingTest() {
        Response<Integer> actual = service.checkYear("12lkj");
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateNumberOfHoursMinutesSecondsTest() {
        Day day = new Day(5, 25, 20);
        Response<Day> actual = service.calculateNumberOfHoursMinutesSeconds(19520);
        Response<Day> expected = new Response<>(Status.OK, ErrorCode.NONE, day);
        assertEquals(actual, expected);
    }
}
