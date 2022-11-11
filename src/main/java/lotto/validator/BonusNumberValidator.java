package lotto.validator;

public class BonusNumberValidator extends NumberValidator{
    public static void hasValidBonusNumber(int bonusNumber){
        hasValidRange(bonusNumber);
    }
}
