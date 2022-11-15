package lotto.domain.lotto;

import lotto.exception.LottoIllegalArgumentException;

public class Bonus {
    private int number;

    public Bonus(int number) {
        this.number = number;
    }

    public Bonus(String number) {
        this.number = convertInteger(number);
    }

    private int convertInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new LottoIllegalArgumentException("보너스 번호는 숫자여야합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
