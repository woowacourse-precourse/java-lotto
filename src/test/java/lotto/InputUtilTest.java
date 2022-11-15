package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validation.ValidationUtil;
import static org.assertj.core.api.Assertions.assertThat;

public class InputUtilTest {
    @DisplayName("checkSizeTest")
    @Test
    void checkSizeTest() {
        boolean origin = ValidationUtil.checkSize(List.of(1, 2, 3));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("haveDuplicatedNumbersTest")
    @Test
    void haveDuplicatedNumbersTest() {
        boolean origin = ValidationUtil.
                haveDuplicatedNumbers(List.of(1, 2, 3, 3));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("isIntegerTest")
    @Test
    void isIntegerTest() {
        boolean origin = ValidationUtil.isInteger("abc");

        assertThat(origin).isEqualTo(false);

    }

    @DisplayName("isUnitsOf1000WonTest")
    @Test
    void isUnitsOf1000WonTest() {
        boolean origin = ValidationUtil.isUnitsOf1000Won("1000");

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("haveUndefinedNumberTest")
    @Test
    void haveUndefinedNumberTest() {
        boolean origin = ValidationUtil.haveUndefinedNumber(List.of("", "1"));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("areValidNumbersTest")
    @Test
    void areValidNumbersTest() {
        boolean origin = ValidationUtil
                .areValidNumbers(List.of("1", "2", "3", "4", "5", "6"));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("isDuplicatedWithWinningNumbersTest")
    @Test
    void isDuplicatedWithWinningNumbersTest() {
        boolean origin = ValidationUtil.isDuplicatedWithWinningNumbers("1",
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(origin).isEqualTo(false);
    }
}
