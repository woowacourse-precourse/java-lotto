package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CheckLottosPrizeTest {
    private List<Lotto> lottos = new ArrayList<Lotto>(List.of(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45)))
    );
    private Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private Integer bonusNumber = 7;
    private CheckLottosPrize checkLottoPrize = new CheckLottosPrize(lottos, winningNumber, bonusNumber);
    /**
     * getAnswerCount
     * getRank
     * getTotalPrize
     */

    @Test
    void getAnswerCount_LottoAndWinningNumberMatchFourTimes_Return2(Lotto lotto) {
        checkLottoPrize();
    }
}