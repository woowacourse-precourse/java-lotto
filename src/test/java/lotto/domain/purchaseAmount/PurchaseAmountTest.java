package lotto.domain.purchaseAmount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class PurchaseAmountTest {
    @ValueSource(strings = {"1000", "3000", "40000", "11000", "600000"})
    @ParameterizedTest
    void 로또_구매_금액을_입력받고_유효성_검사한_후_long_형태로_반환한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        long expected = Long.parseLong(input);

        long result = PurchaseAmount.getPurchaseAmount();

        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"999", "1111", "4000a", "abc", "$%^"})
    @ParameterizedTest
    void 로또_구매_금액을_입력받고_유효성_검사했을_때_이상이_있을_경우_예외처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(PurchaseAmount::getPurchaseAmount).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {
            "1000 : 1",
            "2000 : 2",
            "8000 : 8",
            "10000 : 10",
            "45000 : 45",
            "100000 : 100",
    }, delimiter = ':')
    @ParameterizedTest
    void 구매한_로또의_개수를_구한다(long purchaseAmount, long expected) {
        long result = PurchaseAmount.getLottoPurchaseCount(purchaseAmount);

        assertThat(result).isEqualTo(expected);
    }
}