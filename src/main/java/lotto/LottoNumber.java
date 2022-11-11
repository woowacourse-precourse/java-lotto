package lotto;


public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN || number > MAX) {
            throw new LottoInputException("[ERROR]");
        }
    }

    public int getNumber() {
        return number;
    }
}
