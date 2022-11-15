package lotto.service;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.LottoGrade;

public class RankService {
    private final List<Rank> ranks;
    public static int totalWinning = 0;

    public RankService() {
        this.ranks = List.of(Rank.values());
    }

    public int getRank(LottoGrade lottoGrade) {
        int correctNumberCount = lottoGrade.getCorrectNumberCount();
        boolean isBonusCorrect = lottoGrade.isBonusCorrect();
        int rankNumber = 1;

        for (Rank rank : ranks) {
            if (rank.getWinning(correctNumberCount, isBonusCorrect) != null) {
                totalWinning += rank.getWinning(correctNumberCount, isBonusCorrect);
                return rankNumber;
            }
            rankNumber += 1;
        }
        throw new VerifyError(); // 이 단계까지 오는 경우 Rank의 조건을 잘못 설정한 것이므로 수정 필요
    }

    public int getTotalWinning() {
        return totalWinning;
    }
}
