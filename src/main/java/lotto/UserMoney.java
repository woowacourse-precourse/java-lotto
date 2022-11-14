package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserMoney {

    public int getUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        moneyCheck(Integer.parseInt(money));

        return Integer.parseInt(money);
    }

    private void moneyCheck(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        if (money < 0) {
            throw new IllegalArgumentException();
        }
    }
}
