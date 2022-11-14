package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("LottoResult 객체 생성 성공")
    void createLottoResult_Success() {
        // Given
        String purchaseAmountStr = "8000";
        int purchaseAmount = Integer.parseInt(purchaseAmountStr);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto), purchaseAmountStr);
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

        // When
        LottoResult lottoResult = new LottoResult(lottos, winningNumber);

        // Then
        assertThat(lottoResult.getWinCount().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getYield()).isEqualTo((double) LottoRank.FIRST.getReward() / purchaseAmount * 100);
    }

}