package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validation.ValidationUtil;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
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
}
