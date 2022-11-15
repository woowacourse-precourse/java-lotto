package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoPieces;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("천 원 단위로 지불하지 않으면 예외가 발생한다")
    @Test
    void exectionWhenDidntPayUnit1000() {
        assertThatThrownBy(
            () -> new LottoPieces(new Money(1100))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천 원 이하로 지불하면 예외가 발생한다")
    @Test
    void exectionWhenPayUnDer1000() {
        assertThatThrownBy(
            () -> new LottoPieces(new Money(0))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
