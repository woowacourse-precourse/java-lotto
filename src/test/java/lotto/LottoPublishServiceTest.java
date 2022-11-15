package lotto;

import lotto.service.LottoPublishService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPublishServiceTest {

    @DisplayName("금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyNotDivideLottoPrice() {
        LottoPublishService lottoPublishService = new LottoPublishService();

        assertThatThrownBy(() -> lottoPublishService.publish(1010L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 맞는 갯수의 로또를 발급받는다.")
    @Test
    void publishLotto10000() {
        LottoPublishService lottoPublishService = new LottoPublishService();

        Assertions.assertThat(lottoPublishService.publish(10000L).size()).isEqualTo(10);
    }
}