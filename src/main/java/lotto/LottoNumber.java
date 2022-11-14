package lotto;

public class LottoNumber extends Number implements Comparable<LottoNumber> {

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.getNumber() - lottoNumber.getNumber();
    }

    LottoNumber(Integer number) {
        this.validate(number);
        this.setNumber(number);
    }

    private void validate(Integer number) {
        this.validator.throwIfNotInRange(number);
    }

}
