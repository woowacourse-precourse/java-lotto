package lotto;

import java.util.List;

public class BonusNumberFiveCalculatorGenerator {
    public static boolean BonusNumberFivetoSixCalculator(int returnNumber, List<List<Integer>> correctNumberList, int bonusNumber, List<Integer> resultNumber, int i) {
        if(returnNumber == 5) {
            returnNumber = JudgmentBonusNumberGenerator.JudgmentBonusNumber(correctNumberList, bonusNumber, returnNumber, i);
            resultNumber.add(returnNumber);
            return true;
        } return false;
    }
}
