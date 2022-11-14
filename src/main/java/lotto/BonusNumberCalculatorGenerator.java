package lotto;

import java.util.ArrayList;
import java.util.List;

public class BonusNumberCalculatorGenerator {
    public static List<Integer> BonusNumberCalculator(int InputMoney, List<List<Integer>> correctNumberList, List<Integer> correctNumber, int bonusNumber) {
        List<Integer> resultNumber = new ArrayList<>();

        for(int i=0; i<InputMoney; i++) {
            int returnNumber = CompareNumber.jugementNumber(correctNumberList.get(i), correctNumber);
            if(returnNumber == 5) {
                returnNumber = JudgmentBonusNumberGenerator.JudgmentBonusNumber(correctNumberList, bonusNumber, returnNumber, i);
                resultNumber.add(returnNumber);
                continue;
            }
            if(returnNumber == 6) {
                returnNumber = 7;
            }
            resultNumber.add(returnNumber);
        }
        return resultNumber;
    }
}
