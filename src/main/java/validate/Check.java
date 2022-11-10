package validate;

import java.util.List;

public class Check {

    public static int countLottoTicket(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액이 아닙니다. (지폐만 가능)");
        }

        return money / 1000;
    }
}
