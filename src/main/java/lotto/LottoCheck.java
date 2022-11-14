package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCheck {
    private final int bonusNum;
    private List<List<Integer>> lottoNums;
    private List<Integer> winningNum;

    public List<String> checkRank;

    public LottoCheck(List<List<Integer>> lottoNums, List<Integer> winningNum, int bonusNum) {
        checkRank = new ArrayList<>();
        this.lottoNums = lottoNums;
        this.winningNum = winningNum;
        this.bonusNum = bonusNum;

        lottoCheck();
    }

    private void lottoCheck() {
        for (List<Integer> num : lottoNums) {
            int matchNum = setCheckRank(num);
            if (matchNum > 2)
                checkRank.add(bonusNumCheck(matchNum));
        }
    }

    private int setCheckRank(List<Integer> num) {
        int count = 0;

        for (Integer n : num) {
            if (winningNum.contains(n))
                count++;
        }

        return count;
    }

    private String bonusNumCheck(int matchNum) {
        if (matchNum == 5) {
            winningNum.contains(bonusNum);
            return (Integer.toString(matchNum) + "+");
        }
        return Integer.toString(matchNum);
    }
}
