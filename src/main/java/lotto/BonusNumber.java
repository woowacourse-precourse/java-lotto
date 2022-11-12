package lotto;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int input) {
        Validator validator = new Validator();
        this.bonusNumber = validator.validDateBonusNumber(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
