package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class CompareNum {

    private final UserLottos userLottos;
    private final PrizeLotto prizeLotto;
    private final BonusNumber bonusNumber;

    EnumMap<WinCase, Integer> result = new EnumMap<>(WinCase.class);

    public CompareNum(UserLottos userLottos, PrizeLotto prizeLotto, BonusNumber bonusNumber) {
        this.userLottos = userLottos;
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
        for (WinCase winCase : WinCase.values()){
            this.result.put(winCase, 0);
        }
    }

    public Map<WinCase, Integer> calculateResult(){
        for (Lotto userLotto : this.userLottos.getUserLottos()){
            int equalNumber = calculateEqualNumber(userLotto);
            boolean equalBonusNumber = isEqualBonusNumber(userLotto);
            WinCase winCaseKey = WinCase.getEqualCount(equalNumber,equalBonusNumber);
            this.result.put(winCaseKey, this.result.get(winCaseKey)+1);
        }
        return this.result;
    }

    public int calculateEqualNumber(Lotto userLotto){
        int equalCount = 0;
        for (int num: userLotto.getNumbers()){
            if(this.prizeLotto.getPrizeLotto().contains(num)){
                equalCount++;
            }
        }
        return equalCount;
    }

    public boolean isEqualBonusNumber(Lotto userLotto){
        boolean equalBonusNumber = false;
        if(userLotto.getNumbers().contains(this.bonusNumber.getBonusNumber())){
            equalBonusNumber = true;
        }
        return equalBonusNumber;
    }

    public EnumMap<WinCase, Integer> getResult(){
        return this.result;
    }
}
