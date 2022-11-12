package lotto.domain;

import lotto.standard.Place;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    private Amount amount;

    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void inputNumberDividedBy1000RemainingNumber() {

        assertThatThrownBy(() -> new Amount(12344))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원보다 적은 금액을 넣으면 예외가 발생한다")
    @Test
    void inputNumberRatherThan1000() {

        assertThatThrownBy(() -> new Amount(567))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("만 원 입력 시 10개를 반환한다")
    @Test
    void returnPurchasesNumber() {
        amount = new Amount(10000);

        assertThat(amount.getPurchasesQuantity()).isEqualTo(10);
    }

    @DisplayName("8000원을 투입하고 5등하면 수익률은 62.5%다")
    @Test
    void doCalculateEarningRate() {
        amount = new Amount(8000);

        Map<Place, Integer> provide = new HashMap<>();
        provide.put(Place.FIRST, 0);
        provide.put(Place.SECOND, 0);
        provide.put(Place.THIRD, 0);
        provide.put(Place.FOURTH, 0);
        provide.put(Place.FIFTH, 1);

        assertThat(amount.getEarningRate(provide)).isEqualTo(62.5);
    }
}
