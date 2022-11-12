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
}
