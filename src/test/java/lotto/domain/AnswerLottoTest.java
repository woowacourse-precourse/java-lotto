package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerLottoTest {
    @DisplayName("당첨 번호에 1 ~ 45 사이의 값이 아닌 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void createAnswerLottoByOverLimitNumber(){
        assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 55), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void

}
