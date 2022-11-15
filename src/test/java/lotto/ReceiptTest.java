package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReceiptTest {
    @DisplayName("금액이 음수로 주어졌을 때 Receipt 생성 기능 테스트")
    @Test
    void createReceiptByNegative() {
        Assertions.assertThatThrownBy(() -> new Receipt("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 0으로 주어졌을 때 Receipt 생성 기능 테스트")
    @Test
    void createReceiptByZero() {
        Assertions.assertThatThrownBy(() -> new Receipt("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000으로 나누어지지 않을 때 Receipt 생성 기능 테스트")
    @Test
    void createReceiptByNotDividedValue() {
        Assertions.assertThatThrownBy(() -> new Receipt("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 기능 테스트")
    @Test
    void buyTest() {
        Receipt receipt = new Receipt("2000");
        List<Lotto> lottos = receipt.buy();
        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }
}
