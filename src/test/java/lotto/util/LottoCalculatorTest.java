package lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    @DisplayName("lotto 번호와 당첨 번호를 비교하여 등수 계산 성공")
    void calculateWinCount_Success() {
        // Given
        String purchaseAmountStr = "8000";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto), purchaseAmountStr);
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

        // When
        Map<LottoRank, Integer> winCount = LottoCalculator.calculateWinCount(lottos, winningNumber);

        // Then
        assertThat(winCount.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 성공")
    void calculateYield_Success() {
        // Given
        String purchaseAmountStr = "8000";
        int purchaseAmount = Integer.parseInt(purchaseAmountStr);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto), purchaseAmountStr);
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");
        Map<LottoRank, Integer> winCount = LottoCalculator.calculateWinCount(lottos, winningNumber);

        // When
        double yield = LottoCalculator.calculateYield(winCount, purchaseAmount);

        // Then
        assertThat(yield).isEqualTo((double) LottoRank.FIRST.getReward() / purchaseAmount * 100);
    }
}