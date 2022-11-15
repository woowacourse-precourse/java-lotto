package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public double inputPayment() {
        String payment = Console.readLine();
        validateNumeric(payment);
        return Double.parseDouble(payment);
    }

    private static void validateNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
    }
}