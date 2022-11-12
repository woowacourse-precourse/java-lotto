package lotto;

import java.util.Arrays;
import java.util.List;

public class Grader {
    List<Lotto> lottoList;
    List<Integer> answer;
    int bonusNumber;

    public Grader(List<Lotto> lottoList, List<Integer> answer, int bonusNumber) {
        this.lottoList = lottoList;
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public void grade() {
        for (Lotto lotto: lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchNumber = getMatchNumber(lottoNumbers);
            if (matchNumber < Rank.FIVE.getMatchNum()) continue; // 미당첨 처리
            if (isRankTwo(matchNumber, lottoNumbers)) {
                // 2,3등 구분 처리
                matchNumber = Rank.TWO.getMatchNum();
            }
            Rank.getRank(matchNumber).plus();
        }
    }

    private boolean isRankTwo(int matchNumber, List<Integer> lottoNumbers) {
       return matchNumber == 5 && lottoNumbers.contains(bonusNumber);
    }

    public int getMatchNumber(List<Integer> lottoNumbers) {
        int result = 0;
        for (int lottoNum : lottoNumbers) {
            if(answer.contains(lottoNum)) result++;
        }
        return result;
    }

}