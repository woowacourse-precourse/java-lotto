package lotto.view;

import lotto.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @Test
    @DisplayName("구매금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    void getLottoCount() {
        assertThatThrownBy(() -> Application.getLottoCount("30050"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액이 8000원일 경우 로또 개수는 8개다.")
    void getLottoCount2() {
        Assertions.assertThat(Application.getLottoCount("8000")).isEqualTo(8);
    }
}