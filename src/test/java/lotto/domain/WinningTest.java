package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("1등, 2등, 4등 당첨")
class WinningTest {
    List<Lotto> lottos;
    List<Integer> winningNumbers;
    int bonus;
    Winning winning;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = mock(Lotto.class);
        Lotto lotto2 = mock(Lotto.class);
        Lotto lotto3 = mock(Lotto.class);
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonus = 7;
        when(lotto1.matchCount(winningNumbers)).thenReturn(6);
        when(lotto2.matchCount(winningNumbers)).thenReturn(5);
        when(lotto2.containsBonus(bonus)).thenReturn(true);
        when(lotto3.matchCount(winningNumbers)).thenReturn(4);
        lottos = List.of(lotto1, lotto2, lotto3);
        winning = new Winning(winningNumbers, bonus);
    }
    @ParameterizedTest(name = "{0}은 당첨 정보에 포함")
    @EnumSource(value = WinningTable.class, names = {"FIRST", "SECOND", "FORTH"})
    void getWinningInfo(WinningTable winningTable) {
        List<WinningTable> winningInfo = winning.getWinningInfo(lottos);
        assertThat(winningInfo.contains(winningTable)).isTrue();
    }

    @ParameterizedTest(name = "{0}은 당첨 정보에 포함되지 않음")
    @EnumSource(value = WinningTable.class, names = {"THIRD", "FIFTH", "LOSE"})
    void getWinningInfo2(WinningTable winningTable) {
        List<WinningTable> winningInfo = winning.getWinningInfo(lottos);
        assertThat(winningInfo.contains(winningTable)).isFalse();
    }


}