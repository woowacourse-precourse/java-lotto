package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스 번호의 범위가 1과 45 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusOutOfRange() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 6)), -3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BONUS_RANGE.getString()),
                () -> assertThatThrownBy(() -> new LottoAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BONUS_RANGE.getString()));
    }

    @DisplayName("보너스 번호가 로또 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusInLottoAnswer() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new LottoAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BONUS_DUPLICATE.getString()));
    }
}
