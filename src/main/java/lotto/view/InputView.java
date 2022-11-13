package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputView {
    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(toNumber(Console.readLine()));
        System.out.println();
        return money;
    }

    private static int toNumber(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }
}
