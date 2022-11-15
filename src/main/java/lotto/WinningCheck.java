package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WinningCheck {

    List<Lotto> lottoList;
    List<Integer> winningNumbers;
    int bonusNumber;

    public WinningCheck(List<Lotto> lottList, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoList = lottList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void winningCheck() {
        for(Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMathCount(lottoNumbers);
            if(matchCount < Rank.FIFTH.getMatchNumber())
                continue;
             if(isRankTwo(matchCount, lottoNumbers))
                 matchCount = Rank.SECOND.getMatchNumber();
             Rank.getRank(matchCount).plus();
        }
        printWinningStatistics();
    }

    public int getMathCount(List<Integer> lottoNumbers) {
        int count = 0;
        for(int lottoNum : lottoNumbers) {
            if(winningNumbers.contains(lottoNum))
                count += 1;
        }
        return count;
    }

    public boolean isRankTwo(int matchCount, List<Integer> lottoNumbers) {
        return matchCount == 5 && lottoNumbers.contains(bonusNumber);
    }

    public void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> System.out.println(rank.getMessage() + rank.getStrCount()));
    }

}
