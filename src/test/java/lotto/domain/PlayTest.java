package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayTest {
    @Test
    public void LottoPlayTest() {
        Lotto lotto = Lotto.from(List.of(1,2,3,4,5,6));
        assertThat(lotto.play(WinningNumber.of(List.of(1,3,4,5,6,7),8))).isEqualTo(Result.FIVE);
    }
}
