package lotto.domain;

import lotto.domain.exception.IllegalArgumentException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {
    @ParameterizedTest(name = "구매자가 로또 한 장 가격인 1,000원 미만의 금액으로 로또를 구매하려고 하면 예외가 발생한다. (구매 금액 : {0})")
    @ValueSource(ints = {100, 500, 999})
    void createBuyerByUnderLottoPrice(int won) {
        assertThatThrownBy(() -> new Buyer(won))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "구매자가 입력한 구매 금액에 맞춰 로또를 구매할 수 있다. (구매 금액 : {0})")
    @ValueSource(ints = {1_000, 5_000, 10_000, 12_345, 99_999})
    void calculateNumberOfLottos(int won) {
        Buyer buyer = new Buyer(won);
        assertThat(buyer.getLottos().size()).isEqualTo((won - (won % LOTTO_PRICE)) / LOTTO_PRICE);
    }

    @ParameterizedTest(name = "구매자가 구매한 로또 번호 리스트는 오름차순으로 정렬되어 있다. (구매 금액 : {0})")
    @ValueSource(ints = {1_000, 5_000, 10_000, 12_345, 99_999})
    void ascendingSortLottos(int won) {
        Buyer buyer = new Buyer(won);
        for (Lotto lotto : buyer.getLottos()) {
            assertThat(lotto.getNumbers()).isSortedAccordingTo(Comparator.naturalOrder());
        }
    }
}
