package util;

import static org.junit.jupiter.api.Assertions.*;

import constant.ErrorMessage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputWinningLottoNumber;
import view.OutputView;

class ValidateBonusNumberTest {


    @Test
    @DisplayName("(예외)문자열에서 숫자 변환 과정 오류(문자열에 숫자가 아닌 문자가 있을 경우 ")
    void wrongConvertInteger() {
        Assertions.assertThatThrownBy(() -> {
            int bonusNumber = 0;
            try {
                bonusNumber = Integer.parseInt("2j");
            } catch (Exception e) {
                throw new IllegalArgumentException(
                    ErrorMessage.ERROR_BONUS_NOT_NUMBER.getMessage());
            }
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            ValidateBonusNumber.validateBonusNumber("2j");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("(예외)보너스 번호가 로또 번호 범위 안에 있는지?")
    void wrongNumberisInRange() {
        int wrongBonusNumber = 46;
        Assertions.assertThatThrownBy(() -> {
            if (wrongBonusNumber < 1 || wrongBonusNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_OVERRANGE.getMessage());
            }
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            ValidateBonusNumber.validateBonusNumber("47");
        }).isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    @DisplayName("(예외)보너스 번호가 이미 당첨번호 안에 있다면")
    void isBonusNumberInWinningTicket() {
        int bonusNumber = 6;
        List<Integer> lottoTicket = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatThrownBy(() -> {
            int rightBonusNumber = bonusNumber;
            if (lottoTicket.stream().anyMatch(n -> rightBonusNumber == n)) {
                throw new IllegalArgumentException(
                    ErrorMessage.ERROR_BONUS_DUPLICATE_WINNING.getMessage());
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }


}