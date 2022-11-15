package lotto.model.lucky;


import lotto.TryCatchException;

public class BonusNumber {

    private static final int COUNT_OF_BONUS_NUMBER = 1;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NEGATIVE_SIGN = '-';
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber) {
        checkNull(bonusNumber);
        validateSign(bonusNumber);
        isNumeric(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void checkNull(String input) {
        try {
            if (input == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The bonus number must consists validate numbers.");
        }
    }

    private void validateSign(String input) {
        long count = input.chars()
            .filter(this::isSign)
            .count();

        try {
            if (count != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The winning number must be positive");
        }
    }

    public boolean isSign(int c){
        return c == NEGATIVE_SIGN;
    }

    private void isNumeric(String input) {
        long count = input.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .filter(i -> i >= MIN_LOTTO_NUMBER)
            .filter(i -> i <= MAX_LOTTO_NUMBER)
            .count();

        try {
            if (count != COUNT_OF_BONUS_NUMBER) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The bonus number must not consists validate numbers.");
        }
    }

    public boolean contains(Integer number) {
        return bonusNumber.equals(number);
    }

}
