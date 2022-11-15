package lotto.domain;

public class LottoNumber {
    private Integer number;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;

    public LottoNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호의 숫자가 1-45 사이가 아닙니다.");
        }
    }

    public Integer getLottoNumber() {
        return this.number;
    }
}
