package lotto.exception;

import lotto.Lotto;

import java.util.List;

public class Exception {

    public static void verifyMoney(String money) {
        if (money.matches("\\D")) {
            throw new IllegalArgumentException();
        }
        if(Integer.parseInt(money) % 1000 != 0 || Integer.parseInt(money) == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void verifyLottoListVolume(List<Lotto> lottoList, int volume) {
        if(lottoList.size() != volume) {
            throw new IllegalArgumentException();
        }
    }
}
