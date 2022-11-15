package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class ExceptionHandlerTest {

    ExceptionHandler exceptionHandler = new ExceptionHandler();

    @Test
    void test_emptyException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.emptyException("");
        });
    }

    @Test
    void test_noNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.noNumberException("2k");
        });
    }

    @Test
    void test_amountUnitException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.amountUnitException("200");
        });
    }

    @Test
    void test_lottoNumberException() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.lottoNumberException(list);
        });
    }

    @Test
    void TEST_overlapException() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 3, 1);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.overlapException(numbers);
        });
    }

    @Test
    void test_splitResultNoNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.splitResultNoNumberException("2,3,5,1,r,5");
        });
    }

    @Test
    void TEST_numberRangeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            exceptionHandler.numberRangeException(55);
        });
    }
}
