package lotto;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.LottoCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @DisplayName("두 로또 비교 계산기가 유효한지 확인.")
    @Test
    void checkLottoCalculatorException3() {
        Lotto lotto1 = new Lotto(List.of(1, 47, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(LottoCalculator.getCountOfSameNumber(lotto1, lotto2)).isEqualTo(5);

        lotto1 = new Lotto(List.of(1, 3, 4, 7, 5, 6));
        lotto2 = new Lotto(List.of(12, 22, 32, 42, 15, 16));
        Assertions.assertThat(LottoCalculator.getCountOfSameNumber(lotto1, lotto2)).isEqualTo(0);

        lotto1 = new Lotto(List.of(1, 47, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(1, 47, 3, 4, 5, 6));
        Assertions.assertThat(LottoCalculator.getCountOfSameNumber(lotto1, lotto2)).isEqualTo(6);


    }
}