package lotto;

import camp.nextstep.edu.missionutils.Console;

// enum 사용해보자
public class User {

    private final String inputMoney;
    static int money;

    public User(String inputMoney) {
        this.inputMoney = inputMoney;
        setMoneyNumber();
        validateMoney();
    }

    private void setMoneyNumber() {
        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액으로 숫자를 입력해주세요.");
        }
    }

    private void validateMoney() {
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매해주세요.");
        }
    }
}
