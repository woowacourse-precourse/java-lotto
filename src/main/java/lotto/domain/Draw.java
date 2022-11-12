package lotto.domain;

public class Draw {
    private final Lotto winnerNumbers;
    private final Integer bonusNumber;

    public Draw(Lotto winnerNumbers, Integer bonusNumber) {
        validate(bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if (!isCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (winnerNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isCorrectRange(Integer number) {
        return 1 <= number && number <= 45;
    }
}
