package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoJudgeTest {

    @DisplayName("번호 일치 개수 및 순위 판별")
    @Test
    void judgeLottoTest() {
        int bonusNumber = 13;
        List<Integer> winningNumbers = List.of(1,5,17,23,34,41);
        ArrayList<List<Integer>> lotteries = new ArrayList<>();
        lotteries.add(List.of(1,5,7,15,21,24)); // 순위 외
        lotteries.add(List.of(1,5,17,32,34,41)); // 3등
        lotteries.add(List.of(1,5,13,23,34,41)); // 2등
        lotteries.add(List.of(1,5,17,23,34,41)); // 1등
        lotteries.add(List.of(1,5,17,23,34,44)); // 3등

        LottoJudge lottoJudge = new LottoJudge();

        Map<LottoRank, Integer> rankCount = lottoJudge.judgeLotto(lotteries, winningNumbers,bonusNumber);

        assertEquals(rankCount.get(LottoRank.FIRST), 1);
        assertEquals(rankCount.get(LottoRank.SECOND), 1);
        assertEquals(rankCount.get(LottoRank.THIRD), 2);
    }

    @DisplayName("총 수익률 판별")
    @Test
    void profitLottoTest() {
        int money = 20000;
        List<LottoRank> rankCount = List.of(LottoRank.FIFTH, LottoRank.FIFTH);
        List<LottoRank> SecondRankCount = List.of(LottoRank.THIRD, LottoRank.FOURTH);

        LottoJudge lottoJudge = new LottoJudge();
        assertEquals(lottoJudge.profitLotto(rankCount, money),"50.0");
        assertEquals(lottoJudge.profitLotto(SecondRankCount, money), "7750.0");
    }
}