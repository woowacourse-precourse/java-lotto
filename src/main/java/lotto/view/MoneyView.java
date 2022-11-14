package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MoneyView {
    static int money;
    public static int get() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            money = Integer.parseInt(input);
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
        check();
        return money;
    }

    private static void check() {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야합니다.");
        }
    }
}
