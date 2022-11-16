package lotto;

import java.util.ArrayList;
import java.util.List;

public class BonusNumberCalculatorGenerator {
    public static List<Integer> BonusNumberCalculator(int InputMoney, List<List<Integer>> correctNumberList, List<Integer> correctNumber, int bonusNumber) {
        List<Integer> resultNumber = new ArrayList<>();

        for(int i=0; i<InputMoney; i++) {
            int returnNumber = CompareNumber.jugementNumber(correctNumberList.get(i), correctNumber);

            if(BonusNumberFiveCalculatorGenerator.BonusNumberFivetoSixCalculator(returnNumber, correctNumberList, bonusNumber, resultNumber, i)) {
                continue;
            }

            BonusNumberSixCalculatorGenerator.BonusNumberSixtoSevenCalculator(returnNumber);
            resultNumber.add(returnNumber);
        }
        return resultNumber;
    }
}
