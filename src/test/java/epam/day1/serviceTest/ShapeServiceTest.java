package epam.day1.serviceTest;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.ShapeService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShapeServiceTest {

    ShapeService service = new ShapeService();

    @Test
    public void checkNumberPositiveTest() {
        Response<Double> actual = service.checkRadius("123.4");
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 123.4);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberNegativeValidationTest() {
        Response<Double> actual = service.checkRadius("10024.565");
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkNumberParsingTest() {
        Response<Double> actual = service.checkRadius("1002lki");
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaOfCircleInscribedInSquarePositiveTest() {
        Response<Double> actual = service.calculateAreaOfCircleInscribedInSquare(12.4);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 9.734);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaOfSquareInscribedInCirclePositiveTest() {
        Response<Double> actual = service.calculateAreaOfSquareInscribedInCircle(31.4);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 20.0);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateDifferenceInSquaresPositiveTest() {
        Response<Double> actual = service.calculateDifferenceInSquares(18.8, 2.0);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 9.4);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaOfCirclePositiveTest() {
        Response<Double> actual = service.calculateAreaOfCircle(4.0);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 50.24);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateCircumferenceOfCirclePositiveTest() {
        Response<Double> actual = service.calculateCircumferenceOfCircle(2.0);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 12.56);
        assertEquals(actual, expected);
    }
}
