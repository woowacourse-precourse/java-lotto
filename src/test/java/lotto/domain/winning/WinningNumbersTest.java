package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .withMessage("[ERROR] 당첨 번호의 총 개수가 6이 아닙니다.");
    }

    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createWinningNumbersByLessSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 10))
                .withMessage("[ERROR] 당첨 번호의 총 개수가 6이 아닙니다.");
    }

    @DisplayName("당첨 번호들 중 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .withMessage("[ERROR] 당첨 번호에 중복된 숫자가 존재합니다.");
    }
}
