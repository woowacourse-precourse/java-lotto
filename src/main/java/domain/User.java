package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private final int inputUserMoney;

    public User(int inputUserMoney) {
        validateInputUserMoney(inputUserMoney);
        this.inputUserMoney = inputUserMoney;
    }

    public void validateInputUserMoney(int inputUserMoney) {
        try {
            if (inputUserMoney % 1000 != 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액 입력값은 1000원 단위여야 합니다");
            System.exit(0);
        }
    }
}
