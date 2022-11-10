package lotto.domain;


import java.util.Arrays;
import java.util.List;


public class WinJudgment {

    public int matchNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int matchNum = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                matchNum++;
            }
        }

        return matchNum;
    }

    public boolean matchBonusNumber(int computerBonusNum, int playerBonusNum) {
        if (computerBonusNum == playerBonusNum)
            return true;

        return false;
    }

    public LottoRanking rankingJudgment(int matchNum, boolean bonusNum) {
        LottoRanking ranking = Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.getMatches() == matchNum)
                .findAny()
                .orElse(LottoRanking.LOSING);
        if(ranking == LottoRanking.SECOND_PLACE)
            if(!bonusNum)
                ranking = LottoRanking.THIRD_PLACE;

        return ranking;
    }

}
