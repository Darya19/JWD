package epam.day1.serviceTest;

import com.epam.day1.response.Status;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.service.FunctionService;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class FunctionServiceTest {
    FunctionService service = new FunctionService();

    @Test
    public void checkXValuePositiveTest() {
        Response<Double> actual = service.checkXValue("123.3");
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 123.3);
        assertEquals(actual, expected);
    }

    @Test
    public void checkXValueNegativeValidationTest() {
        Response<Double> actual = service.checkXValue("1526.366");
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.VALIDATION_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test
    public void checkXValueNegativeParsingTest() {
        Response<Double> actual = service.checkXValue("1526.366za");
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.PARSING_ERROR, null);
        assertEquals(actual, expected);
    }

    @Test(description = "calculation y for x >= 3")
    public void calcYPositiveTest() {
        Response<Double> actual = service.calculateY(4.0);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 5.0);
        assertEquals(actual, expected);
    }

    @Test(description = "calculation y for x < 3")
    public void calculateYPositiveTest() {
        Response<Double> actual = service.calculateY(2.0);
        Response<Double> expected = new Response<>(Status.OK, ErrorCode.NONE, 0.5);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateYNegativeTest() {
        Response<Double> actual = service.calculateY(1.8171206);
        Response<Double> expected = new Response<>(Status.ERROR, ErrorCode.DIVISION_BY_ZERO, null);
        assertEquals(actual, expected);
    }

    @Test(description = "calculation y for x >= 3")
    public void calculateXAndY() {
        Map<Double, Double> expectedValues = new HashMap<>();
        expectedValues.put(2.0, -2.185039863261519);
        expectedValues.put(3.0, -0.1425465430742778);
        expectedValues.put(4.0, 1.1578212823495777);
        Response<Map<Double, Double>> actual = service.calculateXAndY(2.0, 4.0, 1.0);
        Response<Map<Double, Double>> expected = new Response<>(Status.OK, ErrorCode.NONE, expectedValues);
        assertEquals(actual, expected);
    }

}
