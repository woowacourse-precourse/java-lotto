package lotto.model.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("정상적인 보너스 번호를 생성하는 경우")
    @Test
    void BonusNumber() {
        String validBonusNumber = "7";
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatCode(() -> new BonusNumber(validBonusNumber, winningNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상적인 보너스 번호를 생성하는 경우 예외처리")
    @Test
    void BonusNumberException() {
        String notNumberBonusNumber = "a";
        String notNumberBonusNumber2 = "a1";
        String invalidRangeBonusNumber = "0";
        String invalidRangeBonusNumber2 = "46";
        String duplicatedBonusNumber = "6";
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatThrownBy(() -> new BonusNumber(notNumberBonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BonusNumber(notNumberBonusNumber2, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BonusNumber(invalidRangeBonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BonusNumber(invalidRangeBonusNumber2, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BonusNumber(duplicatedBonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}