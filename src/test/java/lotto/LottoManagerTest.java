package lotto;


import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @Test
    @DisplayName("등수 판별 결과에 따른 당첨 수익률 분석 기능이 정상동작한다.")
    void analyzeWell() {
        Map<LottoPlace, Integer> records = new HashMap<>();

        records.put(LottoPlace.FIRST, 0);
        records.put(LottoPlace.SECOND, 4); // 120_000_000
        records.put(LottoPlace.THIRD, 2); // 60_000_000
        records.put(LottoPlace.FORTH, 1); // 50_000
        records.put(LottoPlace.FIFTH, 20); // 100_000
        records.put(LottoPlace.NONE, 120); // 0

        int margin = LottoPlace.FIRST.getPrizeMoney() * 0
                + LottoPlace.SECOND.getPrizeMoney() * 4
                + LottoPlace.THIRD.getPrizeMoney() * 2
                + LottoPlace.FORTH.getPrizeMoney() * 1
                + LottoPlace.FIFTH.getPrizeMoney() * 20;
        double expectedMarginRate = 100.0 * margin / (double) ((0+4+2+1+20+120) * 1000);

        double actualMarginRate = new LottoManager().analyzeMarginRate(records);

        Assertions.assertThat(actualMarginRate).isEqualTo(expectedMarginRate);
    }

}