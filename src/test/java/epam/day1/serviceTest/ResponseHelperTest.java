package epam.day1.serviceTest;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;
import com.epam.day1.service.ResponseHelper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ResponseHelperTest {

    @Test
    public void makeOkResponsePositiveTest() {
        Response<Integer> actual = ResponseHelper.makeOkResponse(5);
        Response<Integer> expected = new Response<>(Status.OK, ErrorCode.NONE, 5);
        assertEquals(actual, expected);
    }

    @Test
    public void makeErrorResponsePositiveTest() {
        Response<Integer> actual = ResponseHelper.makeErrorResponse(ErrorCode.DIVISION_BY_ZERO);
        Response<Integer> expected = new Response<>(Status.ERROR, ErrorCode.DIVISION_BY_ZERO, null);
        assertEquals(actual, expected);
    }
}
