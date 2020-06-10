package epam.day1.serviceTest;

import com.epam.day1.entity.Point;
import com.epam.day1.response.Status;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.service.PointService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PointServiceTest {

    PointService service = new PointService();

    @Test
    public void checkCoordinatesValuePositiveTest() {
        Response<Point> actual = service.checkCoordinatesValue("123.3", "12.5");
        Response<Point> expected = new Response<>(Status.OK, ErrorCode.NONE, new Point(123.3, 12.5));
        assertEquals(actual, expected);
    }

    @Test
    public void checkCoordinatesValueNegativeValidationTest() {
        Response<Point> actual = service.checkCoordinatesValue("10222.3", "-5");
        Response<Point> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkCoordinatesValueNegativeParsingTest() {
        Response<Point> actual = service.checkCoordinatesValue("125.njh", "5");
        Response<Point> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void compareDistancePositiveTest() {
        Point a = new Point(12.5, 5.3);
        Point b = new Point(56.2, 14.8);
        Response<Point> actual = service.compareDistance(a, b);
        Response<Point> expected = new Response<>(Status.OK, ErrorCode.NONE, a);
        assertEquals(actual, expected);
    }
}

