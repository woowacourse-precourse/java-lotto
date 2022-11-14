package lotto;

import lotto.domain.LottoEarnings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEarningsTest {
    List<Integer> matchResult = List.of(3,1,1,5,5,1);
    List<Boolean> hasBonus = List.of(true, true, false, true, false, true);

    @DisplayName("로또 구매 총액을 계산하는 테스트")
    @Test
    void checkCalculatePrize() {
        int result = 31_505_000;
        assertThat(LottoEarnings.calculatePrize(matchResult,hasBonus))
                .isEqualTo(result);
    }

}







