package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int getUserMoney() {
        try {
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
