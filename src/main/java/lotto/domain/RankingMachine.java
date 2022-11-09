package lotto.domain;

import java.util.List;
import lotto.domain.LottoGrade;
import lotto.domain.Rank;

public class RankingMachine {
    private final List<Rank> ranks;

    public RankingMachine() {
        this.ranks = List.of(Rank.values());
    }

    public int getRank(LottoGrade lottoGrade) {
        int correctNumberCount = lottoGrade.getCorrectNumberCount();
        boolean isBonusCorrect = lottoGrade.isBonusCorrect();
        int rankNumber = 1;

        for (Rank rank : ranks) {
            if (rank.isCurrentRank(correctNumberCount, isBonusCorrect)) {
                return rankNumber;
            }
            rankNumber += 1;
        }
        throw new VerifyError(); // 이 단계까지 오는 경우 Rank의 조건을 잘못 설정한 것이므로 수정 필요
    }
}
