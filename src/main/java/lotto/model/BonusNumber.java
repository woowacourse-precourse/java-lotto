package lotto.model;

import lotto.Lotto;

/*
 * 보너스 숫자 1개를 의미하는 객체
 */

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        Lotto.validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

}
