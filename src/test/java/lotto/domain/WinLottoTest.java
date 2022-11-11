package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinLottoTest {

    Lotto lotto;

    @BeforeEach
    void 로또_생성() {
        lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 로또 보너스 번호 검증 테스트")
    @Test
    void createWinLotto() {
        WinLotto winlotto = WinLotto.of(lotto, 10);
        assertThat(winlotto.getBonus()).isEqualTo(10);
    }

    @DisplayName("당첨로또의 숫자가 보너스 번호와 중첩될시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void createWinLottoByDuplicatedBonus(int input) {
        assertThatThrownBy(() -> {
            WinLotto winLotto = WinLotto.of(lotto, input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 숫자는 보너스번호와 중첩될수 없습니다.");
    }

    @DisplayName("당첨로또의 보너스 번호가 1보다 작거나 45보다 클 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 99})
    public void createWinLottoBonusByGreaterThanMaxOrLesserThanMin(int input) {
        assertThatThrownBy(() -> {
            WinLotto winLotto = WinLotto.of(lotto, input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 45보다 크거나 1보다 작을수 없습니다.");
    }
}
