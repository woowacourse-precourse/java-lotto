package lotto;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.getNumber();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        return this.number == ((LottoNumber) obj).getNumber();
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    private void validateRange(int number) {
        if (number > Constants.UPPER_BOUND_OF_LOTTO_NUMBER || number < Constants.LOWER_BOUND_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentError("number is out of range");
        }
    }


}