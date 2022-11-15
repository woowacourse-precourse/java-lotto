package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayTest {
    private WinningNumber winningNumber;
    @BeforeEach
    public void setUp() {
        winningNumber = WinningNumber.of(List.of(1,2,3,4,5,6),7);
    }
    @Test
    public void NoneTest() {
        Lotto lotto = Lotto.from(List.of(2, 13, 22, 32, 38, 45));
        assertThat(lotto.play(winningNumber)).isEqualTo(Result.NONE);
    }
    @Test
    public void ThreeTest() {
        Lotto lotto = Lotto.from(List.of(1, 3, 5, 14, 22, 45));
        assertThat(lotto.play(winningNumber)).isEqualTo(Result.THREE);
    }
    @Test
    public void FiveTest() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 43));
        assertThat(lotto.play(winningNumber)).isEqualTo(Result.FIVE);
    }
    @Test
    public void FiveBonusTest() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 7, 43));
        assertThat(lotto.play(winningNumber)).isEqualTo(Result.FIVE_BONUS);
    }
    @Test
    public void SixTest() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.play(winningNumber)).isEqualTo(Result.SIX);
    }
}
