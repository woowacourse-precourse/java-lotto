package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 결과를 추가한다.")
    @Test
    void addResult() {
        LottoResult actual = new LottoResult();
        actual.addResult(Rank.FIRST);
        actual.addResult(Rank.FIFTH);

        LottoResult expected = new LottoResult();
        expected.addResult(Rank.FIRST);
        expected.addResult(Rank.FIFTH);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("총 상금을 반환한다.")
    @Test
    void reward() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.SECOND);
        lottoResult.addResult(Rank.THIRD);
        lottoResult.addResult(Rank.FOURTH);
        lottoResult.addResult(Rank.FIFTH);
        lottoResult.addResult(Rank.MISS);

        assertThat(lottoResult.reward()).isEqualTo(new Money(2_031_555_000));
    }
}
