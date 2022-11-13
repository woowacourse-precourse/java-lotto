package lotto.global;

import lotto.model.Lotto;

import java.util.List;
import java.util.NoSuchElementException;

public class LogicException {

    public static final String ERROR = "[ERROR]";
    public static final String NUM_ERROR = "숫자만 입력해야 합니다.";

    public static void verifyMoney(String money) {
        if (!money.matches("^\\d*")) {
            System.out.println(ERROR + " 올바르지 않은 입력입니다.");
//            throw new IllegalArgumentException(ERROR + " " + NUM_ERROR);
            throw new NoSuchElementException(NUM_ERROR);
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
