package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<LottoRank> countWinning(List<Integer> lotto, List<List<Integer>> userLotto) {
        List<LottoRank> ranking = new ArrayList<>();

        for(List<Integer> numbers : userLotto) {
            int count = countMatchNumber(lotto, numbers);
            boolean bonusNumber = checkBonusNumber(count, numbers);

            ranking.add(rankLotto(count, bonusNumber));
        }

        return ranking;
    }

    public int countMatchNumber(List<Integer> lotto, List<Integer> userLotto) {
        int count = 0;

        for(int number : userLotto) {
            if(lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 입력받는 lotto가 bonus 번호를 가지고있으면 true, 아니면 false 반환
     * @param userLotto
     * @return
     */
    public boolean checkBonusNumber(int matchNumber, List<Integer> userLotto) {
        if(matchNumber == LottoRank.SECOND.getMatchNumber()) {
            if(userLotto.contains(BonusNumber.BONUS_NUMBER.getNumber())) {
                return true;
            }
        }
        return false;
    }

    public LottoRank rankLotto(int count, boolean bonusNumber) {
        for(LottoRank rank : LottoRank.values()) {
            System.out.println("count = " + count + " rankNumber = " + rank.getMatchNumber());
            if(count == rank.getMatchNumber() && bonusNumber == rank.getBonusNumber()) {
                return rank;
            }
        }

        return LottoRank.BLANK;
    }
}
