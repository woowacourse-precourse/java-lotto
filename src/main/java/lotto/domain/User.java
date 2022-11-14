package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public int getMoneyInput() {
        int money = Integer.parseInt(readLine());
        validateMoney(money);
        return money;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 돈이 1000원 단위가 아닙니다.");
        }
    }
}
