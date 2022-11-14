package lotto;

import java.util.List;

public class LottoSystem {
    private List<Integer> winNumbers;
    private int bonusNumbers;

    public LottoSystem() {

    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusNumbers(int bonusNumbers) {
        this.bonusNumbers = bonusNumbers;
    }


    public WinInfo judgeWin(Lotto target) {
        int matchedCnt = getMatchedCnt(target.getNumbers());
        int bonusMatchedCnt = getBonusMatchedCnt(target.getNumbers());

        return WinInfo.get(matchedCnt, bonusMatchedCnt);
    }

    private int getMatchedCnt(List<Integer> target) {
        int result = 0;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i) == this.winNumbers.get(i)) {
                result++;
            }
        }
        return result;
    }

    private int getBonusMatchedCnt(List<Integer> target) {
        int result = 0;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i) == this.bonusNumbers) {
                result++;
                break;
            }
        }
        return result;
    }
}
