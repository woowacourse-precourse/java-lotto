package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPublisherTest {

    @DisplayName("금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyNotDivideLottoPrice() {
        LottoPublisher lottoPublisher = new LottoPublisher();

        assertThatThrownBy(() -> lottoPublisher.publish(1010))
                .isInstanceOf(IllegalArgumentException.class);
    }

}