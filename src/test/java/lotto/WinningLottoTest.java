package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.WinningLotto;
import lotto.utils.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 번호로 이루어진 로또를 생성한다.")
    @Test
    void createWinningLotto() {
        WinningLotto lotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lotto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("입력한 보너스 번호가 로또 숫자의 범위가 아닌 경우 예외가 발생한다.")
    @Test
    void addBonusNumberByOverRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
    }

    @DisplayName("입력한 보너스 번호가 기존 번호와 중복된 경우 예외가 발생한다.")
    @Test
    void addBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HAVE_OVERLAP.getMessage());
    }

}
