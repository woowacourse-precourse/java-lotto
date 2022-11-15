package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    /** 사용자에게 로또를 살 금액을 입력 요청하는 메서드 */
    public static int askMoney() throws NumberFormatException {
        System.out.println(Messages.ASK_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    /** 복권 구매 */
    public static int inputMoney(int Money) {
        vaildMoney(Money);
        isZero(Money);
        int lotto = Money / 1000;
        return lotto;
    }

    private static void vaildMoney(int Money) {
        if (Money % 1000 != 0) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_DIVDE1000);
        }
    }

    private static void isZero(int Money) {
        if (Money == 0) {
            throw new IllegalArgumentException(Messages.ERROR_NULL);
        }
    }
}
