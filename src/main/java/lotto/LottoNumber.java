package lotto;

public class LottoNumber {
    private final int MIN = 1;
    private final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("번호는 1~45 까지만 허용됩니다.");
        }
    }

    public int getNumber() {
        return number;
    }


}
