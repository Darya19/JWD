package epam.day1.serviceTest;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.MathService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MathServiceTest {

    MathService service = new MathService();

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
    public void calculateLastDigitOfSquareTest() {
        Response<Integer> actual = service.calculateLastDigitOfSquare(255);
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 5);
        assertEquals(actual, expected);
    }
}
