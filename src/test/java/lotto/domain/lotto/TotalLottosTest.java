package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class TotalLottosTest {
    @ValueSource(strings = {"10", "10000", "22", "600000"})
    @ParameterizedTest
    void n개의_중복되지_않는_로또를_구매했는지_확인한다(long lottoPurchaseCount) {
        TotalLottos totalLottos = new TotalLottos(lottoPurchaseCount);
        List<Lotto> lottos = totalLottos.getTotalLottos();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            for (int i = 0; i < numbers.size() - 1; i++) {
                assertThat(numbers.get(i)).isNotEqualTo(numbers.get(i + 1));
            }
        }
    }
}