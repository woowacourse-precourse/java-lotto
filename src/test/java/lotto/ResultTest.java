package lotto;

import lotto.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.PlaceStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 등수_갯수_확인() {
        Result lottoResult = new Result(List.of(NOTHING, FIFTH, FIFTH, FIRST, SECOND, SECOND, FOURTH, FIFTH));
        lottoResult.getWinningResult();
        int result = lottoResult.getFifth();
        assertThat(result).isEqualTo(3);

        int result2 = lottoResult.getSecond();
        assertThat(result2).isEqualTo(2);

        int result3 = lottoResult.getThird();
        assertThat(result3).isEqualTo(0);
    }

    @Test
    void 당첨금_확인() {
        Result lottoResult = new Result(List.of(NOTHING, FIFTH, FIFTH, FIRST, SECOND, SECOND, FOURTH, FIFTH));
        lottoResult.getWinningResult();
        int result = lottoResult.getReward();
        assertThat(result).isEqualTo(2060065000);
    }

    @Test
    void 로또_갯수() {
        Result lottoResult = new Result(List.of(NOTHING, FIFTH, FIFTH, FIRST, SECOND, SECOND, FOURTH, FIFTH));
        lottoResult.getWinningResult();
        int result = lottoResult.getLottoSize();
        assertThat(result).isEqualTo(8);
    }
}
