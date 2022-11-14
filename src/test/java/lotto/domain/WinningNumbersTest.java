package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("보너스 번호가 입력한 로또 번호들과 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45내의 수가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 47))
                .isInstanceOf(IllegalArgumentException.class);
    }
}