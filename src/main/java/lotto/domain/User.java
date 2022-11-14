package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;

    public User() {

    }
    public void getInputMoney() {
        String input = Console.readLine();
        int money = Integer.parseInt(input);
        validateMoney(money);
    }
    public void validateMoney(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }
}
