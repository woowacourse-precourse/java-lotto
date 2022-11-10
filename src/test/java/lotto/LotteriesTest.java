package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Lotteries;

public class LotteriesTest {

    @DisplayName("복권 구매가격 예외 처리 테스트")
    @ParameterizedTest(name = "{index} {displayName} input = {0}")
    @ValueSource(ints = {0, 1100, -1000})
    void checkLottoPriceException(int input) {
        Assertions.assertThatThrownBy(() -> Lotteries.generateLotteriesByPrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
