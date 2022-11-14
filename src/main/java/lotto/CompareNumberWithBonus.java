package lotto;

import java.util.ArrayList;
import java.util.List;

public class CompareNumberWithBonus {
    public static List<Integer> jugementNumberWithBonus(int InputMoney) {
        List<Integer> resultNumber = new ArrayList<>();
        List<List<Integer>> correctNumberList = FinalUserNumberGenerator.FinalUserNumber(InputMoney);
        List<Integer> correctNumber = Lotto.CorrectLottoNumber();

        int bonusNumber = BonusNumberGenerator.createBonusNumber(correctNumber);

        for(int i=0; i<InputMoney; i++) {
            int returnNumber = CompareNumber.jugementNumber(correctNumberList.get(i), correctNumber);
            if (correctNumberList.get(i).contains(bonusNumber)) {
                returnNumber += 1;
            }
            resultNumber.add(returnNumber);
        }
        return resultNumber;
    }
}
