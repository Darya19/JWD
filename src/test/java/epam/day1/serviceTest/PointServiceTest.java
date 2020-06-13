package epam.day1.serviceTest;

import com.epam.day1.entity.Point;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.PointService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PointServiceTest {

    PointService service;
    Point a;
    Point b;

    @BeforeClass
    public void setUp() {
        service = new PointService();
        a = new Point(12.5, 5.3);
        b = new Point(56.2, 14.8);
    }

    @Test
    public void checkCoordinatesValuePositiveTest() {
        Response<Point> actual = service.checkCoordinatesValue(123.3, 12.5);
        Response<Point> expected = new Response<>(Status.OK, ErrorCode.NONE, new Point(123.3, 12.5));
        assertEquals(actual, expected);
    }

    @Test
    public void checkCoordinatesValueNegativeTest() {
        Response<Point> actual = service.checkCoordinatesValue(10222.3, 5.1);
        Response<Point> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void compareDistancePositiveTest() {
        Response<Point> actual = service.compareDistance(a, b);
        Response<Point> expected = new Response<>(Status.OK, ErrorCode.NONE, a);
        assertEquals(actual, expected);
    }
}

