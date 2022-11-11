package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputLotto {

    int inputMoney() {
        String input = Console.readLine();
        validateNumber(input);
        int money = Integer.parseInt(input);
        validateDivideThousand(money);
        return money;
    }

    int validateNumber(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    void validateDivideThousand(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1000단위의 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }
}