package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validation.ValidationUtil;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {
    @DisplayName("로또의 숫자 개수 테스트")
    @Test
    void checkSizeTest() {
        boolean origin = ValidationUtil.checkSize(List.of(1, 2, 3));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("로또의 숫자가 중복되었는지 테스트")
    @Test
    void haveDuplicatedNumbersTest() {
        boolean origin = ValidationUtil.
                haveDuplicatedNumbers(List.of(1, 2, 3, 3));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("로또 번호로 숫자가 입력되었는지 테스트")
    @Test
    void isIntegerTest() {
        boolean origin = ValidationUtil.isInteger("abc");

        assertThat(origin).isEqualTo(false);

    }

    @DisplayName("구입 금액이 1000원 단위인지 테스트")
    @Test
    void isUnitsOf1000WonTest() {
        boolean origin = ValidationUtil.isUnitsOf1000Won("1000");

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("로또 번호가 빈 칸이 아닌지 테스트")
    @Test
    void haveUndefinedNumberTest() {
        boolean origin = ValidationUtil.haveUndefinedNumber(List.of("", "1"));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("로또 번호가 유효한지 테스트")
    @Test
    void areValidNumbersTest() {
        boolean origin = ValidationUtil
                .areValidNumbers(List.of("1", "2", "3", "4", "5", "6"));

        assertThat(origin).isEqualTo(true);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 테스트")
    @Test
    void isDuplicatedWithWinningNumbersTest() {
        boolean origin = ValidationUtil.isDuplicatedWithWinningNumbers("1",
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(origin).isEqualTo(false);
    }
}
