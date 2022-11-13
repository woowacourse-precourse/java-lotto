package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayTest {
    private Lotto lotto;
    @BeforeEach
    public void setUp() {
        lotto = Lotto.from(List.of(1,2,3,4,5,6));
    }
    @Test
    public void NoneTest() {
        assertThat(lotto.play(WinningNumber.of(List.of(1,2,8,9,10,11),12))).isEqualTo(Result.NONE);
    }
    @Test
    public void ThreeTest() {
        assertThat(lotto.play(WinningNumber.of(List.of(1,2,3,9,10,11),12))).isEqualTo(Result.THREE);
    }
    @Test
    public void FiveTest() {
        assertThat(lotto.play(WinningNumber.of(List.of(1,2,3,4,5,7),8))).isEqualTo(Result.FIVE);
    }
    @Test
    public void FiveBonusTest() {
        assertThat(lotto.play(WinningNumber.of(List.of(1,2,3,4,7,8),5))).isEqualTo(Result.FIVE_BONUS);
    }
    @Test
    public void SixTest() {
        assertThat(lotto.play(WinningNumber.of(List.of(1,2,3,4,5,8),6))).isEqualTo(Result.SIX);
    }
}
