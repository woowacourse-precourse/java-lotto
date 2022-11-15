package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("1보다 작은 보너스번호를 등록하려하면 예외가 발생한다")
    @Test
    void registerSmallBonusNumber() {
        assertThatThrownBy(() -> winningNumbers.registerBonusNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45보다 큰 보너스번호를 등록하려하면 예외가 발생한다")
    @Test
    void registerBigBonusNumber() {
        assertThatThrownBy(() -> winningNumbers.registerBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 중복된 보너스번호를 등록하려하면 예외가 발생한다")
    @Test
    void registerDuplicatedNumber() {
        assertThatThrownBy(() -> winningNumbers.registerBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
