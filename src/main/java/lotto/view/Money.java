package lotto.view;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Money {
    int money;

    public int get() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            money = Integer.parseInt(input);
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
        return money;
    }

    void check() {
    }
}
