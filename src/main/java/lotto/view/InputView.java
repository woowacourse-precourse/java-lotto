package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = convertInteger(Console.readLine());

        isValidationForMoney(money);

        return money;
    }

    private void isValidationForMoney(int money) {
        if (isLessThan1000(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        if (!(isDivideBy1000(money))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private int convertInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private boolean isLessThan1000(int money) {
        return money < 1000;
    }

    private boolean isDivideBy1000(int money) {
        if (money % 1000 == 0) {
            return true;
        }
        return false;
    }
}