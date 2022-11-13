package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {
    @DisplayName("checkLottoResult 함수가 정상적으로 작동한다")
    @ParameterizedTest
    @CsvSource({"1, 2, 3, 4, 5, 6," +
            "1, 2, 3, 4, 5, 7," +
            "1, 2, 3, 4, 8, 9," +
            "1, 2, 3, 4, 5, 6, 7," +
            "0, 0, 1, 0, 1, 1"})
    void runCheckLottoResult(int l1Number1, int l1Number2, int l1Number3,
                             int l1Number4, int l1Number5, int l1Number6,
                             int l2Number1, int l2Number2, int l2Number3,
                             int l2Number4, int l2Number5, int l2Number6,
                             int l3Number1, int l3Number2, int l3Number3,
                             int l3Number4, int l3Number5, int l3Number6,
                             int winningNumber1, int winningNumber2, int winningNumber3,
                             int winningNumber4, int winningNumber5, int winningNumber6, int bonusNumber,
                             int result1, int result2, int result3,
                             int result4, int result5, int result6) {
        List<Lotto> tempLotteries = new ArrayList<>();
        tempLotteries.add(new Lotto(List.of(l1Number1, l1Number2, l1Number3, l1Number4, l1Number5, l1Number6)));
        tempLotteries.add(new Lotto(List.of(l2Number1, l2Number2, l2Number3, l2Number4, l2Number5, l2Number6)));
        tempLotteries.add(new Lotto(List.of(l3Number1, l3Number2, l3Number3, l3Number4, l3Number5, l3Number6)));
        Lotteries lotteries = new Lotteries(tempLotteries);
        WinningNumber winningNumber = new WinningNumber(
                new Lotto(List.of(winningNumber1, winningNumber2, winningNumber3,
                        winningNumber4, winningNumber5, winningNumber6)), bonusNumber);
        LottoResult lottoResult = lotteries.checkLottoResult(winningNumber);
        Map<Rank, Integer> lottoResultTest = lottoResult.getLottoResult();
        assertThat(lottoResultTest.get(Rank.NOTHING)).isEqualTo(result1);
        assertThat(lottoResultTest.get(Rank.FIFTH)).isEqualTo(result2);
        assertThat(lottoResultTest.get(Rank.FOURTH)).isEqualTo(result3);
        assertThat(lottoResultTest.get(Rank.THIRD)).isEqualTo(result4);
        assertThat(lottoResultTest.get(Rank.SECOND)).isEqualTo(result5);
        assertThat(lottoResultTest.get(Rank.FIRST)).isEqualTo(result6);
    }
}
