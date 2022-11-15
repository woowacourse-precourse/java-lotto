package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public double inputPayment() {
        printPaymentMessage();
        String payment = Console.readLine();
        validateNumeric(payment);
        return Double.parseDouble(payment);
    }

    public static void validateNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
    }

    private void printPaymentMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}