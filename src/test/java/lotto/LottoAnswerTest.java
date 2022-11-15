package lotto;

import lotto.domain.LottoAnswer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAnswerTest {

    @DisplayName("같은 숫자가 있을 경우 exception 발생 테스트")
    @Test
    void createLottoSameNumber() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 5), "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 정답 로또에 같은 숫자가 있을 경우 exception 발생 테스트")
    @Test
    void createLottoSameBonusNumber() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
