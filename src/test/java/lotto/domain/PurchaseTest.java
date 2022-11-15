package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PurchaseTest {
    @DisplayName("로또 개수를 정상적으로 구하는지 확인한다.")
    @Test
    void getLottoCount_정상동작() {
        int input = Purchase.getLottoCount(5000);
        assertThat(input).isEqualTo(5);
    }

    @DisplayName("구입금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void getLottoCount_잘못된_입력() {
        assertThatThrownBy(() -> Purchase.getLottoCount(5500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}