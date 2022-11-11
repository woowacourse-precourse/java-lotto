package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int inputMoney() {
        int money = Integer.parseInt(Console.readLine());
        validate(money);
        return money;
    }

    public void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]입력값이 잘못되었습니다.");
        }
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR]값이 0 입니다.");
        }
    }


}
