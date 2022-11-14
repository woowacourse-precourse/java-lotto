package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("양수가 아니라면 예외가 발생한다.")
    @Test
    void validatePositiveNumber() {
        // given
        int positive = 8_000;
        int zero = 0;
        int minus = -1;

        // expected
        Validator.validatePositiveNumber(positive);
        assertThatThrownBy(() -> Validator.validatePositiveNumber(zero))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validatePositiveNumber(minus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 금액단위를 따르는지 여부 반환 - 따르지 않음")
    @Test
    void validateUnitStandardNotFollow() {
        // given
        int purchaseAmount = 8_001;

        // expected
        assertThatThrownBy(() -> Validator.validateUnitStandard(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 금액단위를 따르는지 여부 반환 - 따름")
    @Test
    void validateUnitStandardFollow() {
        // given
        int purchaseAmount = 8_000;

        // expected
        Validator.validateUnitStandard(purchaseAmount);
    }

    @DisplayName("당첨 번호 개수를 6개 입력했는지 확인 - 따르지 않음")
    @Test
    void validatePlayNumbersCountNotFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5);

        // expected
        assertThatThrownBy(() -> Validator.validatePlayNumbersCount(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 개수를 6개 입력했는지 확인 - 따름")
    @Test
    void validatePlayNumbersCountFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 6);

        // expected
        Validator.validatePlayNumbersCount(playerNumbers);
    }

    @DisplayName("로또 번호가 범위 안의 값인지 확인")
    @Test
    void validatePlayerNumberRange() {
        // given
        int playerNumber = 45;
        int playerNumberNotInRange = 0;

        // expected
        Validator.validatePlayerNumberRange(playerNumber);
        assertThatThrownBy(() -> Validator.validatePlayerNumberRange(playerNumberNotInRange))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위 안에 값인지 확인 - 따르지 않음")
    @Test
    void validatePlayNumbersRangeNotFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 46);

        // expected
        assertThatThrownBy(() -> Validator.validatePlayNumbersRange(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위 안에 값인지 확인 - 따름")
    @Test
    void validatePlayNumbersRangeFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 45);

        // expected
        Validator.validatePlayNumbersRange(playerNumbers);
    }

    @DisplayName("당첨 번호에 중복된 값이 있는지 확인 - 따르지 않음")
    @Test
    void validatePlayNumbersDuplicationNotFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 5);

        // expected
        assertThatThrownBy(() -> Validator.validatePlayNumbersDuplication(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 값이 있는지 확인 - 따름")
    @Test
    void validatePlayNumbersDuplicationFollow() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 45);

        // expected
        Validator.validatePlayNumbersDuplication(playerNumbers);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 확인 - 중복됨")
    @Test
    void validateBonusNumberDuplicationInPlayerNumbersNotFollow() {
        // given
        int bonusNumber = 6;
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 6);

        // expected
        assertThatThrownBy(() -> Validator.validateBonusNumberDuplicationInPlayerNumbers(bonusNumber, playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 확인 - 중복되지 않음")
    @Test
    void validateBonusNumberDuplicationInPlayerNumbersFollow() {
        // given
        int bonusNumber = 7;
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 6);

        // expected
        Validator.validateBonusNumberDuplicationInPlayerNumbers(bonusNumber, playerNumbers);
    }
}