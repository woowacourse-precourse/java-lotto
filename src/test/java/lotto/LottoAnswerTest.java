package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
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
    private Lotto lotto;
    private LottoAnswer lottoAnswer;

    {
        try {
            lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            lottoAnswer = new LottoAnswer(lotto, 7);
        } catch (Exception e) {
        }
    }

    @DisplayName("보너스 번호의 범위가 1과 45 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusOutOfRange() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoAnswer(lotto, -3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BONUS_RANGE.getString()),
                () -> assertThatThrownBy(() -> new LottoAnswer(lotto, 46))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BONUS_RANGE.getString()));
    }

    @DisplayName("보너스 번호가 로또 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusInLottoAnswer() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new LottoAnswer(lotto, 3))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BONUS_DUPLICATE.getString()));
    }

    @DisplayName("타겟 넘버가 lottoAnswer에 포함되는 여부를 정상적으로 판단한다.")
    @Test
    void isNumberInAnswer_정상_동작_확인() {
        assertAll(
                () -> assertThat(lottoAnswer.isNumberInAnswer(5)).isEqualTo(true),
                () -> assertThat(lottoAnswer.isNumberInAnswer(7)).isEqualTo(false),
                () -> assertThat(lottoAnswer.isNumberInAnswer(8)).isEqualTo(false)
        );
    }

    @DisplayName("타겟 넘버가 Bonus와 일치하는 여부를 판단한다.")
    @Test
    void isNumberEqualToBonus_정상_동작_확인() {
        assertAll(
                () -> assertThat(lottoAnswer.isNumberEqaulToBonus(5)).isEqualTo(false),
                () -> assertThat(lottoAnswer.isNumberEqaulToBonus(7)).isEqualTo(true),
                () -> assertThat(lottoAnswer.isNumberEqaulToBonus(8)).isEqualTo(false)
        );
    }


}
