package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    private int inputUserMoney;

    public int getInputUserMoney() {
        return inputUserMoney;
    }

    public void setInputUserMoney(int inputUserMoney) {
        validateInputUserMoney(inputUserMoney);
        this.inputUserMoney = inputUserMoney;
    }

    private void validateInputUserMoney(int inputUserMoney) {
        try {
            if (inputUserMoney % 1000 != 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액 입력값은 1000원 단위여야 합니다");
            System.exit(0);
        }
    }
}
