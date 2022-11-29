package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputBonusLottoValidatorTest {

    @DisplayName("보너스 로또 번호가 로또 번호 범위(1~46) 밖이면 예외를 발생한다.")
    @Test
    void createInvalidBonusNumberByOverRange() {
        assertThatThrownBy( () -> InputBonusLottoValidator.validateInputBonusLotto(List.of(1,2,3,4,5,6), "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createInvalidBonusNumberByCharacter() {
        assertThatThrownBy( () -> InputBonusLottoValidator.validateInputBonusLotto(List.of(1,2,3,4,5,6), "A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createDuplicateBonusNumber() {
        assertThatThrownBy( () -> InputBonusLottoValidator.validateDuplicate(List.of(1,2,3,4,5,6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}