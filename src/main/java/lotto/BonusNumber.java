package lotto;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String input) {
        Validator validator = new Validator();
        this.bonusNumber = validator.validDateBonusNumber(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
