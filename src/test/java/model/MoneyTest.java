package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @ParameterizedTest(name = "{index}  money = {0}")
    @ValueSource(ints = {500, 1500, 999, 1001})
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> {
            new Money(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1,000원으로 나누어 떨어져야 합니다.");
    }

    @ParameterizedTest(name = "{index}  {0}원으로 {1}개")
    @CsvSource(value = {"1000:1", "15000:15", "34567000:34567"}, delimiter = ':')
    void 구입_금액으로_구입할_로또_개수를_계산한다(int purchaseAmount, int count) {
        Money money = new Money(purchaseAmount);
        assertEquals(count, money.getCount());
    }
}
