package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.InputChecker.LIMITED_LENGTH;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputCheckerTest {

    @DisplayName("price 값으로 문자열이 들어오면 예외가 발생한다")
    @Test
    void isNotValidPrice() {
        // given
        String input = "asd";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkPrice(input));
    }

    @DisplayName("price 값에 문자열이 없고, 1000단위면 정상적으로 변환한다.")
    @Test
    void isValidPriceAndWith1000() {
        // given
        String input = "1000";

        // when

        // then
        org.assertj.core.api.Assertions.assertThat(InputChecker.checkPrice(input)).isEqualTo(1000);
    }

    @DisplayName("price 값에 문자열이 없고, 1000단위가 아니면 예외가 발생한다.")
    @Test
    void isValidPriceAndNot1000() {
        // given
        String input = "1213";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkPrice(input));
    }

    @DisplayName("당첨 번호의 개수가 6개이고, 범위에 속하는 숫자라면 정상적으로 반환한다.")
    @Test
    void isSixAndNumberAndRanged() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> integers = InputChecker.checkPrizeLottoInput(input);

        // then
        org.assertj.core.api.Assertions.assertThat(integers.size()).isEqualTo(LIMITED_LENGTH);
    }

    @DisplayName("당첨 번호의 개수가 6개이고, 범위에 속하는 숫자가 아니라면 예외가 발생한다.")
    @Test
    void isSixAndNumberAndNotRanged() {
        // given
        String input = "1,2,3,4,5,66";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkPrizeLottoInput(input));
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void isNotSix() {
        // given
        String input = "1,2,3,4,5";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkPrizeLottoInput(input));
    }

    @DisplayName("보너스 번호가 문자열이면 예외가 발생한다.")
    @Test
    void isBonusString() {
        // given
        String input = "a123";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkBonusNumber(input, new ArrayList<>()));
    }

    @DisplayName("보너스 번호가 범위에 속하지 않으면 예외가 발생한다.")
    @Test
    void isBonusNotRanged() {
        // given
        String input = "123";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkBonusNumber(input, new ArrayList<>()));
    }

    @DisplayName("보너스 번호가 문자열이 아니고, 범위에 속하면 발생하지 않는다.")
    @Test
    void isBonusNotStringAndRanged() {
        // given
        String input = "23";

        // when
        Integer integer = InputChecker.checkBonusNumber(input, new ArrayList<>());

        // then
        org.assertj.core.api.Assertions.assertThat(integer).isEqualTo(23);
    }

    @DisplayName("보너스 번호가 이전에 선택된적이 있으면, 예외가 발생한다.")
    @Test
    void isBonusSelected() {
        // given
        String input = "23";

        // when

        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputChecker.checkBonusNumber(input, List.of(1, 2, 3, 4, 5, 23)));
    }
}
