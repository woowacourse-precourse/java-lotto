package lotto.domain.exceptions;

import lotto.domain.StartLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static lotto.domain.exceptions.BonusInputException.bonusTypeError;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusInputExceptionTest {

    @DisplayName("보너스 번호 입력 값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void bonusTypeError_예외처리_테스트() {
        assertThatThrownBy(() -> bonusTypeError("1000K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 값이 1~45의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void bonusRangeError_예외처리_테스트() {
        StartLotto.bonusNum = 53;
        assertThatThrownBy(BonusInputException::bonusRangeError)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 값이 당첨 번호와 중복일 경우 예외가 발생한다.")
    @Test
    void bonusDuplicate_예외처리_테스트() {
        StartLotto.winNums = new ArrayList<>();
        StartLotto.winNums.add(12);
        StartLotto.winNums.add(17);
        StartLotto.winNums.add(32);
        StartLotto.winNums.add(43);
        StartLotto.winNums.add(15);
        StartLotto.winNums.add(39);
        StartLotto.bonusNum = 39;
        assertThatThrownBy(BonusInputException::bonusDuplicate)
                .isInstanceOf(IllegalArgumentException.class);
    }
}