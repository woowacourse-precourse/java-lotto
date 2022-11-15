package number;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int get() {
        return number;
    }

    private void validateRange(int number) {
        if (number < 0 || number > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
