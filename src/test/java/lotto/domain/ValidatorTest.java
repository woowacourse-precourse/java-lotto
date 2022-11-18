package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {
    @Test
    @DisplayName("구매금액이 숫자로 구성되어 있음을 검증할 수 있는 가?")
    void amount_number_validation_test() {
        String invalidNumber = "1300-";
        int unit = 1000;

        assertThatThrownBy(() -> Validator.amountIsValid(invalidNumber, unit))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액이 지정한 단위로 입력되었는 지 검증할 수 있는 가?")
    void amount_unit_validation_test() {
        String invalidUnit = "13500";
        int unit = 1000;

        assertThatThrownBy(() -> Validator.amountIsValid(invalidUnit, unit))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 로또번호의 길이가 6보다 짧은 경우, 예외를 발생하는 가?")
    void winning_number_short_length_test() {
        String shortLength = "1,2,3,4,5";

        assertThatThrownBy(() -> Validator.winningNumberIsValid(shortLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 로또번호의 길이가 6보다 긴 경우, 예외를 발생하는 가?")
    void winning_number_over_length_test() {
        String longLength = "1,2,3,4,5,6,7,8";

        assertThatThrownBy(() -> Validator.winningNumberIsValid(longLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 로또번호에 허용되지 않은 문자가 포함된 경우 예외를 발생하는 가?")
    void winning_number_include_invalid_char_test() {
        String invalidFormat = "1,2,3,4.5,6,7";

        assertThatThrownBy(() -> Validator.winningNumberIsValid(invalidFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 당첨번호가 서로다른 6자리의 수가 아닌 경우 예외를 발생하는 가?")
    void winning_number_not_unique_test() {
        String includeDuplNumber = "1,2,3,4,5,5";

        assertThatThrownBy(() -> Validator.winningNumberIsValid(includeDuplNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 보너스 번호의 범위가 올바르지 않은 경우, 예외를 발생하는 가?")
    void bonus_number_invalid_range_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        String invalidRange = "97";

        assertThatThrownBy(() -> Validator.bonusNumberIsValid(invalidRange, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 당첨번호에 이미 포함된 경우 예외를 발생하는 가?")
    void bonus_number_not_unique_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        String duplicateNumber = "3";

        assertThatThrownBy(() -> Validator.bonusNumberIsValid(duplicateNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
