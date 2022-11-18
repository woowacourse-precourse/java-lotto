package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        when(lotto1.getNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
        when(lotto2.getNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 7));
        when(lotto3.getNumbers()).thenReturn(List.of(1, 2, 3, 4, 7, 8));

        lottos = List.of(lotto1, lotto2, lotto3);

        winningNumbers = List.of(1,2,3,4,5,6);
        bonus = 7;

        winningResult = new WinningResult(winningNumbers, bonus);
    }

    @DisplayName("당첨 결과 맵<등수, 개수> 생성")
    @Test
    void getMap() {
        Map<WinningTable, Integer> map = winningResult.getMap(lottos);
        assertThat(map.get(WinningTable.FIRST)).isEqualTo(1);
        assertThat(map.get(WinningTable.SECOND)).isEqualTo(1);
        assertThat(map.get(WinningTable.THIRD)).isEqualTo(0);
        assertThat(map.get(WinningTable.FORTH)).isEqualTo(1);
        assertThat(map.get(WinningTable.FIFTH)).isEqualTo(0);
        assertThat(map.get(WinningTable.LOSE)).isEqualTo(0);
    }

    @DisplayName("당첨 결과 가격 리스트 생성")
    @Test
    void getWinningPrices() {
        List<Integer> winningPrices = winningResult.getWinningPrices(lottos);

        assertThat(winningPrices.contains(WinningTable.FIRST.getPrice())).isTrue();
        assertThat(winningPrices.contains(WinningTable.SECOND.getPrice())).isTrue();
        assertThat(winningPrices.contains(WinningTable.THIRD.getPrice())).isFalse();
        assertThat(winningPrices.contains(WinningTable.FORTH.getPrice())).isTrue();
        assertThat(winningPrices.contains(WinningTable.FIFTH.getPrice())).isFalse();
        assertThat(winningPrices.contains(WinningTable.LOSE.getPrice())).isFalse();
    }
}