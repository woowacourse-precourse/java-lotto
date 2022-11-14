package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOfAnswerTest {

    @DisplayName("당첨 번호는 6개가 아닐 시 예외를 발생합니다.")
    @Test
    void 당첨번호_예외처리1() {
        assertThatThrownBy(() -> new LottoOfAnswer(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 중복될 수 없습니다.")
    @Test
    void 당첨번호_예외처리2() {
        assertThatThrownBy(() -> new LottoOfAnswer(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호는 중복될 수 없습니다.")
    @Test
    void 당첨번호_예외처리3() {
        assertThatThrownBy(() -> new LottoOfAnswer(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}