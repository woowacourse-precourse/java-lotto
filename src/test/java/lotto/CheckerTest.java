package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckerTest {
    @DisplayName("로또번호와 당첨번호를 비교하여 당첨된 등수를 알 수 있다.")
    @Test
    void compareLottoNumbers() {
        assertThat(Checker.getRank(5)).isEqualTo(PrizeRank.THIRD);
    }
}
