package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private Lotto lotto;

    @BeforeEach
    void setLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        this.lotto = new Lotto(numbers);
    }

    @DisplayName("당첨 로또 생성 성공")
    @Test
    void createWinningLottoSuccess() {
        int bonusNumber = 10;

        assertThatCode(() -> new WinningLotto(lotto, bonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 로또 번호와 겹치면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        int bonusNumber = 5;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OVERLAPPED_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 1~45의 범위 안에 없으면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        int bonusNumber = 50;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }
}
