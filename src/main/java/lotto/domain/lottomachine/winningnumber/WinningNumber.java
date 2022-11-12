package lotto.domain.lottomachine.winningnumber;

import java.util.Objects;

public class WinningNumber {
    private final int number;

    public WinningNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45에 속해야 합니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 45;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public boolean isSameValue(int number) {
        return this.number == number;
    }
}
