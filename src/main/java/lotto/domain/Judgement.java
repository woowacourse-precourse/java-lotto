package lotto.domain;

import java.util.List;

public class Judgement {
    private int matchCnt = 0;
    private boolean bonusMatch = false;

    public Judgement(){
    }

    public void checkMatch(Lotto userLotto, Lotto wonLotto, int bonusNumber) {
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
