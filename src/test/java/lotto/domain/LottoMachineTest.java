package lotto.domain;

import static lotto.domain.LottoMachine.NOT_ALLOW_DUPLICATED_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("당첨 숫자 내부에 보너스 숫자가 있으면 예외를 던진다.")
    @Test
    void createdByDuplicatedNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThatThrownBy(() -> new LottoMachine(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
    }
}