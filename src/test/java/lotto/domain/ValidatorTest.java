package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {
    @Test
    @DisplayName("구매금액이 숫자이며, 지정한 단위로 입력되었는 지 검증하는 기능 테스트")
    void amount_unit_validation_test() {
        String validAmount = "13000";
        String invalidAmount = "-13000";
        String invalidUnit = "13500";
        int unit = 1000;

        assertThat(Validator.amountUnitIsValid(validAmount, unit))
                .isTrue();
        assertThatThrownBy(() -> Validator.amountUnitIsValid(invalidAmount, unit))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.amountUnitIsValid(invalidUnit, unit))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 로또 번호가 유효한 지 검증하는 기능 테스트")
    void winning_number_validation_test() {
        String validWinningNumber = "1,2,3,4,5,6";
        String shortLength = "1,2,3,4,5";
        String longLength = "1,2,3,4,5,6,7,8";
        String invalidFormat = "1,2,3,4.5,6,7";

        assertThat(Validator.winningNumberIsValid(validWinningNumber))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> Validator.winningNumberIsValid(shortLength))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.winningNumberIsValid(longLength))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.winningNumberIsValid(invalidFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 보너스 번호가 유효한 지 검증하는 기능 테스트")
    void bonus_number_validation_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        String validBonusNumber = "10";
        String invalidRange = "97";
        String duplicateNumber = "3";

        assertThat(Validator.bonusNumberIsValid(validBonusNumber, winningNumber))
                .isEqualTo(Integer.parseInt(validBonusNumber));
        assertThatThrownBy(() -> Validator.bonusNumberIsValid(invalidRange, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.bonusNumberIsValid(duplicateNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
