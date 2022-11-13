package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("5등 1개에 미당첨 7개면 수익률이 0.625이다.")
    @Test
    void oneOfEightIsFifth() {
        LottoResult lottoResult = new LottoResult(
                Map.of("FIRST", 0, "SECOND", 0, "THIRD", 0,
                        "FOURTH", 0, "FIFTH", 1, "NOTHING", 7)
        );
        assertThat(lottoResult.yield()).isEqualTo(0.625);
    }
}
