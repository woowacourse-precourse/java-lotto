package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.service.RankingService;
import org.junit.jupiter.api.Test;

public class RankingTest {

    RankingService rankingService = new RankingService(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(10));

    //1등 - 6개
    @Test
    public void FirstRankingTest() {
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).getRanking(),
                Rank.FIRST.getRanking());
    }

    //2등 - 5개 + 보너스
    @Test
    public void secondRankingTest() {
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))).getRanking(),
                Rank.SECOND.getRanking());
    }

    //3등 - 5개
    @Test
    public void thirdRankingTest() {
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45))).getRanking(),
                Rank.THIRD.getRanking());
    }

    //4등 - 4개
    @Test
    public void fourthRankingTest() {
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45))).getRanking(),
                Rank.FOURTH.getRanking());
    }

    //5등 - 3개
    @Test
    public void fifthRankingTest() {
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45))).getRanking(),
                Rank.FIFTH.getRanking());
    }

    // 꽝
    @Test
    public void unRankingTest() {
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 2, 42, 43, 44, 45))).getRanking(),
                Rank.UN_RANK.getRanking());
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45))).getRanking(),
                Rank.UN_RANK.getRanking());
        assertEquals(rankingService.calculateRanking(new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))).getRanking(),
                Rank.UN_RANK.getRanking());
    }

}
