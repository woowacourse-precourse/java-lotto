package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    public double inputPayment() {
        printPaymentMessage();
        String payment = Console.readLine();
        validateNumeric(payment);
        return Double.parseDouble(payment);
    }

    public void inputWinningNumbers() {
        printWinningNumberMessage();
        String winningNumbers = Console.readLine();
        validateSeparator(winningNumbers);
    }

    public void validateNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
    }

    public void validateSeparator(String input) {
        final String REGEX = "^[0-9,]*$";
        if (!Pattern.matches(REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 숫자와 구분자(,)만 입력될 수 있습니다.");
        }
    }

    private void printPaymentMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}