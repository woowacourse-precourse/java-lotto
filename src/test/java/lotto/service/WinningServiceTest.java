package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class WinningServiceTest {

    @DisplayName("로또번호와 당첨번호를 비교하여 결과를 배열에 저장한다.")
    @Test
    void 낙첨부터_1등까지의_로또_당첨_결과_확인() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 8)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));
        lottos.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));
        lottos.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        int[] rankingCount = WinningService.compareAllLottoWithWinningNumbers(lottos, winningNumber);

        assertArrayEquals(rankingCount, new int[]{1, 1, 1, 1, 1, 1});
    }
}