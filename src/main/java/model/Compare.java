package model;

import java.util.List;

public class Compare {
    private List<Integer> usersLotto;
    private WinLotto winLotto;


    public Compare(List<Integer> usersLotto, WinLotto winLotto) {
        this.usersLotto = usersLotto;
        this.winLotto = winLotto;
    }

    public Result compute(){
        int coincideCount = compareUserLotto();
        boolean bonus = compareBonus();
        Result result = Result.getResult(coincideCount, bonus);

        return result;
    }

    private int compareUserLotto(){
        int coincideCount=0;
        List<Integer> winLottoNumbers = winLotto.getNumbers();
        for (Integer lottoNum : usersLotto) {
            if (winLottoNumbers.contains(lottoNum)) {
                coincideCount++;
            }
        }
        return coincideCount;
    }

    private boolean compareBonus() {
        int bonusNumber = winLotto.getBonusNumber();
        if (usersLotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }






}
