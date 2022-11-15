package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinningResultTest {

    @Test
    void getMap() {
        Lotto lotto1 = mock(Lotto.class);
        Lotto lotto2 = mock(Lotto.class);
        Lotto lotto3 = mock(Lotto.class);

        when(lotto1.getNumbers())
                .thenReturn(List.of(1, 2, 3, 4, 5, 6));
        when(lotto2.getNumbers())
                .thenReturn(List.of(1, 2, 3, 4, 5, 7));
        when(lotto3.getNumbers())
                .thenReturn(List.of(1, 2, 3, 4, 7, 8));

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        WinningLotto winningLotto = mock(WinningLotto.class);
        when(winningLotto.getNumbers())
                .thenReturn(List.of(1, 2, 3, 4, 5, 6));
        when(winningLotto.getBonusNumber())
                .thenReturn(7);

        WinningResult wr = new WinningResult(lottos, winningLotto);
        Map<WinningTable, Integer> map = wr.getMap();
        for (WinningTable wt : map.keySet()) {
            System.out.println(wt + ": " + map.get(wt));
        }
    }

    @Test
    void getList() {
    }
}