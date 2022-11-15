package lotto.UtilTest;

import lotto.Util.Util;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    Util util = new Util();

    @Test
    void splitStringToIntegerArrayTest() {
        String input = "1,2,3,4,5,6";

        List<Integer> result = List.of(1,2,3,4,5,6);

        assertEquals(result,util.splitStringToIntegerArray(input));
    }

    @Test
    void checkNumberRangeTest() {
        int number = 46;
        assertThatThrownBy(() -> util.checkNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkWinningNumberSizeValidationTest() {
        List<Integer> winningNumber = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(() -> util.checkWinningNumberValidation(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkWinningNumberRangeValidationTest2() {
        List<Integer> winningNumber = List.of(1,2,3,46,5,6);
        assertThatThrownBy(() -> util.checkWinningNumberValidation(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
