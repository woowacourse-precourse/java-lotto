package lotto;

public class LottoNumber extends Number {
    LottoNumber(Integer number) {
        this.validate(number);
        this.setNumber(number);
    }

    private void validate(Integer number) {
        this.validator.throwIfNotInRange(this.getNumber());
    }
}
