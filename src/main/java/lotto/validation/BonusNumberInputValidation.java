package lotto.validation;

public class BonusNumberInputValidation {
    public void validateInputIsInteger(String userInputBonusNumber) {
        try {
            Integer.parseInt(userInputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
