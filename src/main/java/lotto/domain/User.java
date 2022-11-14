package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public int getMoneyInput() {
        String money = readLine();
        validateDataType(money);
        validateMoney(Integer.parseInt(money));
        return Integer.parseInt(money);
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 돈이 1000원 단위가 아닙니다.");
        }
    }

    private void validateDataType(String money) {
        if (!money.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력된 돈이 숫자가 아닙니다.");
        }
    }
}
