package lotto.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("5등 1개에 미당첨 7개면 수익률이 0.625(5/8)이다.")
    @Test
    void oneOfEightIsFifth() {
        LottoResult lottoResult = new LottoResult(
                Map.of("FIRST", 0, "SECOND", 0, "THIRD", 0,
                        "FOURTH", 0, "FIFTH", 1, "NOTHING", 7)
        );
        assertThat(lottoResult.yield()).isEqualTo(0.625);
    }
    @DisplayName("2등 1개에 미당첨 6개면 수익률이 30000/7 이다.")
    @Test
    void oneOfEightIsSecond() {
        LottoResult lottoResult = new LottoResult(
                Map.of("FIRST", 0, "SECOND", 1, "THIRD", 0,
                        "FOURTH", 0, "FIFTH", 0, "NOTHING", 6)
        );
        assertThat(lottoResult.yield()).isEqualTo(30000 / 7.0);
    }
    @DisplayName("1등 1개, 2등 1개, 3등 1개, 4등 3개, 5등 4개 미당첨 9990개면 수익률이 203.167 이다.")
    @Test
    void buyTenThousandLotto() {
        LottoResult lottoResult = new LottoResult(
                Map.of("FIRST", 1, "SECOND", 1, "THIRD", 1,
                        "FOURTH", 3, "FIFTH", 4, "NOTHING", 9990)
        );
        assertThat(lottoResult.yield()).isEqualTo(203.167);
    }
    @DisplayName("당첨이 없는 경우 수익률은 0이다.")
    @Test
    void nothingWins() {
        LottoResult lottoResult = new LottoResult(
                Map.of("FIRST", 0, "SECOND", 0, "THIRD", 0,
                        "FOURTH", 0, "FIFTH", 0, "NOTHING", 100)
        );
        assertThat(lottoResult.yield()).isEqualTo(0);
    }
}
