package lotto.validation;

public class WinningValidation extends IllegalArgumentException {

    public WinningValidation() {
    }

    public void throwError(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public void isValidWinning() {
    }

    public void isValidBonus() {
    }

    public void isBlank() {
    }

    public void isNumberAndComma() {
    }

    public void isCorrectRange() {
    }

    public void isCorrectWinningSize() {
    }

    public void isDuplicate() {
    }

    public void isNumber() {
    }

    public void isCorrectBonusSize() {
    }

    public void isContainWinning() {
    }
}