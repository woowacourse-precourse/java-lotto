package lotto;

import java.util.List;

public class CompareNumberWithBonus {
    public static List<Integer> jugementNumberWithBonus(int InputMoney) {
        List<List<Integer>> correctNumberList = FinalUserNumberGenerator.FinalUserNumber(InputMoney);
        List<Integer> correctNumber = Lotto.CorrectLottoNumber();

        int bonusNumber = BonusNumberGenerator.createBonusNumber(correctNumber);

        return BonusNumberCalculatorGenerator.BonusNumberCalculator(InputMoney, correctNumberList, correctNumber, bonusNumber);
    }
}
