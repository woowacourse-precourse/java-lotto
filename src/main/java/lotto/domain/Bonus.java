package lotto.domain;

public class Bonus {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 %d ~ %d 여야 합니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public Bonus(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MIN_NUMBER, MAX_NUMBER));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
