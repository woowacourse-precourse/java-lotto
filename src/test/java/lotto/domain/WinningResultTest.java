package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("1등, 2등, 4등 당첨")
class WinningResultTest {

    List<Lotto> lottos;
    WinningResult winningResult;
    List<Integer> winningNumbers;
    int bonus;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = mock(Lotto.class);
        Lotto lotto2 = mock(Lotto.class);
        Lotto lotto3 = mock(Lotto.class);
        winningNumbers = List.of(1,2,3,4,5,6);
        bonus = 7;
        when(lotto1.matchCount(winningNumbers)).thenReturn(6);
        when(lotto2.matchCount(winningNumbers)).thenReturn(5);
        when(lotto2.containsBonus(bonus)).thenReturn(true);
        when(lotto3.matchCount(winningNumbers)).thenReturn(4);
        lottos = List.of(lotto1, lotto2, lotto3);
        winningResult = new WinningResult(winningNumbers, bonus);
    }

    @DisplayName("당첨된 개수가 1개인 등수")
    @ParameterizedTest
    @EnumSource(value = WinningTable.class, names = {"FIRST", "SECOND", "FORTH"})
    void getMap1(WinningTable winningTable) {
        Map<WinningTable, Integer> map = winningResult.getMap(lottos);
        assertThat(map.get(winningTable)).isEqualTo(1);
    }

    @DisplayName("당첨된 개수가 0개인 등수")
    @ParameterizedTest
    @EnumSource(value = WinningTable.class, names = {"THIRD", "FIFTH", "LOSE"})
    void getMap2(WinningTable winningTable) {
        Map<WinningTable, Integer> map = winningResult.getMap(lottos);
        assertThat(map.get(winningTable)).isEqualTo(0);
    }

    @DisplayName("당첨된 가격 리스트에 포함 됐는지")
    @ParameterizedTest
    @EnumSource(value = WinningTable.class, names = {"FIRST", "SECOND", "FORTH"})
    void getWinningPrices1(WinningTable winningTable) {
        List<Integer> winningPrices = winningResult.getWinningPrices(lottos);
        System.out.println("wp : " + winningPrices);
        System.out.println("wt : " + winningTable.getPrice());
        System.out.println(winningPrices.contains(winningTable.getPrice()));
        assertThat(winningPrices.contains(winningTable.getPrice())).isEqualTo(true);
    }

    @DisplayName("당첨안된 결과 가격 리스트에 포함 안됐는지")
    @ParameterizedTest
    @EnumSource(value = WinningTable.class, names = {"THIRD", "FIFTH", "LOSE"})
    void getWinningPrices2(WinningTable winningTable) {
        List<Integer> winningPrices = winningResult.getWinningPrices(lottos);
        assertThat(winningPrices.contains(winningTable.getPrice())).isFalse();
    }
}