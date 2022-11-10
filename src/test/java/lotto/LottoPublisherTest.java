package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {

    @Test
    void publishLottosAccordingToPayment() {
        // given
        LottoPublisher publisher = new LottoPublisher();

        // when
        int payment = 5000;
        List<Lotto> lottos = publisher.publishLottos(payment);

        // then
        assertThat(lottos.size()).isEqualTo(payment / 1000);
    }

    @Test
    void eachLottoShouldHave6UniqueNumbers() {

    }

    @Test
    void eachLottoShouldHaveUniqueNumbers() {

    }

    @Test
    void eachLottoShouldBeSortedInAscendingOrder() {

    }
}