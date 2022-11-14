package lotto;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {
    private Lotto lotto;

    @BeforeEach
    void createLotto() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되거나 1~45에 해당하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {46, 0, 1})
    void createWinningNumberByOverRange(int element) {
        assertThatThrownBy(() -> new WinningNumber(lotto, element))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {10, 45})
    void getWinningNumberTest(int bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        WinningNumber winningNumber = new WinningNumber(lotto, bonus);
        assertThat(winningNumber.getBonus()).isEqualTo(bonus);
        assertThat(winningNumber.getLotto().getNumbers()).isEqualTo(lottoNumbers);
    }
}
