package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IOUtil {
    public static int moneyInput() {
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            if ( money <= 0 || money % 1000 != 0 ) {
                throw new IllegalArgumentException("[ERROR] 사용자의 금액은 0 이상이고 1000으로 나누어 떨여져야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 사용자의 금액은 숫자를 입력하여야 합니다.");
        }
    }
}
