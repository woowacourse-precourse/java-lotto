package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {

    @Nested
    @DisplayName("publishLottos method test")
    class publishLottosTest {

        @Test
        @DisplayName("발행된 로또의 개수는 (비용 / 1000)개가 되어야 한다.")
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
        @DisplayName("로또는 6개의 서로 다른 수로 이루어져 있어야 한다.")
        void lottoShouldHave6UniqueNumbers() {
            // given
            LottoPublisher publisher = new LottoPublisher();

            // when
            List<Lotto> lottos = publisher.publishLottos(10000);

            // then
            lottos.forEach(lotto -> assertThat(new HashSet<>(lotto.getNumbers()).size()).isEqualTo(6));
        }

        @Test
        @DisplayName("로또 수들은 오름차순으로 정렬되어 있어야 한다.")
        void lottoShouldBeSortedInAscendingOrder() {
            // given
            LottoPublisher publisher = new LottoPublisher();

            // when
            List<Lotto> lottos = publisher.publishLottos(10000);

            // then
            lottos.forEach(lotto -> {
                List<Integer> numbers = lotto.getNumbers();
                List<Integer> copiedNumbers = List.copyOf(numbers);
                numbers.sort(Comparator.comparingInt(o -> o));
                assertThat(copiedNumbers.equals(numbers)).isTrue();
            });
        }
    }
}