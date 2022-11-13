package lotto;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        Validator validator = new Validator();
        validator.validateNumberRange(bonusNumber);
        validator.validateBonusNumber(bonusNumber, winningLotto);
    }
}
