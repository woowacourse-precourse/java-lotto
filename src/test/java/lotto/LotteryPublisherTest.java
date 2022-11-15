package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.random.NextStepLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryPublisherTest {
    private final LotteryPublisher publisher = new LotteryPublisher(new NextStepLottoNumberGenerator());

    @DisplayName("로또 1개를 발행한다.")
    @Test
    void publishOneLotto() {
        publisher.publishOne();
    }

    @DisplayName("발행한 로또는 오름차순으로 정렬되어 있다.")
    @Test
    void publishOneLottoOrdering() {
        List<Integer> publishedLottoNumber = publisher.publishOne().getNumbers();
        List<Integer> orderingTestNumbers = new ArrayList<>(publishedLottoNumber);
        Collections.sort(orderingTestNumbers);

        assertThat(publishedLottoNumber).isEqualTo(orderingTestNumbers);
    }

    @ParameterizedTest(name = "{0}원을 입력시 최대 구매 가능 개수만큼 로또를 발행한다.")
    @ValueSource(ints = {0, 1000, 2000, 13000})
    void publishLottoByPurchaseAmount(int purchaseAmount) {
        List<Lotto> publishedLotto = publisher.publishByPurchaseAmount(purchaseAmount);

        assertThat(publishedLotto.size()).isEqualTo(purchaseAmount / 1000);
    }
}
