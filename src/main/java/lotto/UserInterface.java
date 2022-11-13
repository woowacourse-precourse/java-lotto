package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public int inputPaidMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!validateInputOnlyNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private boolean validateInputOnlyNumber(String input) {
        return input.matches("[0-9]*");
    }
}
