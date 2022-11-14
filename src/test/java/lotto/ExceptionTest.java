package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ExceptionTest extends NsTest {

    @Test
    void notThousandException() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(INPUT_ERROR.error);
        });
    }

    @Test
    void winnerOutOfRangeException(){
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,46");
            assertThat(output()).contains(OUT_OF_RANGE_ERROR.error);
        });
        assertSimpleTest(() -> {
            runException("1000","0,2,3,4,5,6");
            assertThat(output()).contains(OUT_OF_RANGE_ERROR.error);
        });
    }
    @Test
    void duplicatedInputException() {
        assertSimpleTest(() -> {
            runException("1000","1,1,3,4,5,6");
            assertThat(output()).contains(DUPLICATED_ERROR.error);
        });
    }

    @Test
    void bonusNumberOutOfRangeException() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","0");
            assertThat(output()).contains(OUT_OF_RANGE_ERROR.error);
        });
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","46");
            assertThat(output()).contains(OUT_OF_RANGE_ERROR.error);
        });
    }

    @Test
    void inputNotNumberException() {
        assertSimpleTest(() -> {
            runException("a","1,2,3,4,5,6");
            assertThat(output()).contains(NOT_NUMBER_ERROR.error);
        });
        assertSimpleTest(() -> {
            runException("1000","a,1,3,4,5,6");
            assertThat(output()).contains(NOT_NUMBER_ERROR.error);
        });
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","~");
            assertThat(output()).contains(NOT_NUMBER_ERROR.error);
        });
    }

    @Test
    void wrongCountExceptionTest(){
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6,7");
            assertThat(output()).contains(WRONG_COUNT_ERROR.error);
        });
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5");
            assertThat(output()).contains(WRONG_COUNT_ERROR.error);
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
