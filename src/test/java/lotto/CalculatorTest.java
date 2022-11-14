package lotto;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @DisplayName("당첨 번호와 비교해 같은 숫자의 개수를 반환한다.")
    @Test
    void compareLottoByPrizeNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(Calculator.comparePrizeNumber(lotto, List.of(1,2,3,4,5,22)))
                .isEqualTo(5);
    }
}
