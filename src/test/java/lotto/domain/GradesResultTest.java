package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradesResultTest {

    @DisplayName("당첨금액과 구매금액으로 수익률을 계산")
    @Test
    void calculateYieldTest() {
        Map<Grade, Integer> grades = Map.of(Grade.FIFTH, 3);
        GradesResult gradesResult = new GradesResult(grades);
        LottoMoney lottoMoney = new LottoMoney("15000");

        assertThat(gradesResult.calculateYield(lottoMoney))
                .isEqualTo(Grade.FIFTH.getPrizeMoney().getMoney() * 3 / 15000);
    }
}