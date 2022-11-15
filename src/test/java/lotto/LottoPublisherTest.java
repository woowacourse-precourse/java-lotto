package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPublisherTest {
    private static final LottoMetadata lottoMetadata = new LottoMetadata(1, 45, 1000, 6);

    @DisplayName("지불금액이 로또 가격으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void remainderIsNotZero() {
        LottoPublisher lottoPublisher = new LottoPublisher(lottoMetadata);
        Integer payment = 12300;
        assertThatThrownBy(() -> lottoPublisher.purchase(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불금액을 로또 가격으로 나눈 몫과 로또 발행 수가 다르면 예외가 발생한다.")
    @Test
    void purchaseMultipleLotto() {
        LottoPublisher lottoPublisher = new LottoPublisher(lottoMetadata);
        Integer payment = 12000;

        List<Lotto> lottos = lottoPublisher.purchase(payment);

        assertThat(lottos.size()).isEqualTo(payment / lottoMetadata.getWonPerLotto());
    }
}