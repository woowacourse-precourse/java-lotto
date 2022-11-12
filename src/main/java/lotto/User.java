package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    int money = 0;
    public static final int ONEGAMECOST = 1000;

    public int inputMoney() {
        String inputMoney = Console.readLine();
        int money = validate(inputMoney);
        validate(money);
        return money;
    }

    public void validate(int money) {
        if (money % ONEGAMECOST != 0) {
            throw new IllegalArgumentException("[ERROR]금액이 잘못되었습니다. 1000 단위로 입력해주세요.");
        }
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR]금액이 0 입니다.");
        }
    }
    public int validate(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR]");
        }
    }
}
