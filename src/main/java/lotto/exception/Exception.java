package lotto.exception;

import lotto.Lotto;

import java.util.List;

public class Exception {

    private static final String ERROR_MESSAGE = "[ERROR] 숫자만 입력해야 합니다";

    public static void verifyMoney(String money) {
        if (!money.matches("^[0-9]*")) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
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
