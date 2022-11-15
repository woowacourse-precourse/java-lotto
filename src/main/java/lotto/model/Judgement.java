package lotto.model;

import java.util.List;

public class Judgement {
    private int matchCnt = 0;
    private boolean bonusMatch = false;

    public int judgeRank(Lotto userLotto, Lotto wonLotto, int bonusNumber) {
        checkMatch(userLotto, wonLotto, bonusNumber);
        if (matchCnt == 6)
            return 1;
        if (matchCnt == 5 && bonusMatch)
            return 2;
        if (matchCnt == 5 && !bonusMatch)
            return 3;
        if (matchCnt == 4)
            return 4;
        if (matchCnt == 3)
            return 5;
        return 0;
    }

    private void checkMatch(Lotto userLotto, Lotto wonLotto, int bonusNumber) {
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        List<Integer> wonLottoNumbers = wonLotto.getNumbers();
        for (int userNumber : userLottoNumbers) {
            if (wonLottoNumbers.contains(userNumber)) {
                matchCnt++;
            }
        }
        if (userLottoNumbers.contains(bonusNumber)) {
            bonusMatch = true;
        }
    }

}
