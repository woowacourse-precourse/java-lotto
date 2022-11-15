package lotto;

import java.util.List;
import lotto.Constant.LottoSystemValidationError;
import lotto.Constant.WinInfo;

public class LottoSystem {
    private List<Integer> winNumbers;
    private int bonusNumbers;

    public LottoSystem() {

    }

    public void setWinNumbers(List<Integer> winNumbers) {
        validateWinNumbers(winNumbers);
        this.winNumbers = winNumbers;
    }

    public void setBonusNumbers(int bonusNumbers) {
        validateBonusNumbers(bonusNumbers);
        this.bonusNumbers = bonusNumbers;
    }

    private void validateWinNumbers(List<Integer> winNumbers) {
        Lotto lotto = new Lotto(winNumbers);
    }

    private void validateBonusNumbers(int bonusNumbers) {
        if (bonusNumbers < Lotto.NUMBER_MIN || bonusNumbers > Lotto.NUMBER_MAX) {
            //throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw LottoSystemValidationError.BONUS_RANGE.exception;
        }
    }

    public WinInfo judgeWin(Lotto target) {
        int matchedCnt = getMatchedCnt(target.getNumbers());
        int bonusMatchedCnt = getBonusMatchedCnt(target.getNumbers());

        return WinInfo.get(matchedCnt, bonusMatchedCnt);
    }

    private int getMatchedCnt(List<Integer> target) {
        int result = 0;
        for (int i = 0; i < target.size(); i++) {
            if (this.winNumbers.contains(target.get(i))) {
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
