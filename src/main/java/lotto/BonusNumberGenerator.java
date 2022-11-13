package lotto;

public class BonusNumberGenerator {
    public static BonusNumber generateBonusNumber(String bonusNumberInput) {
        int number = Integer.parseInt(bonusNumberInput);
        return new BonusNumber(number);
    }
}
