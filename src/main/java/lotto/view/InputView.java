package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    public double inputPayment() {
        printPaymentMessage();
        String payment = Console.readLine();
        validateNumeric(payment);
        return Double.parseDouble(payment);
    }

    public List<Integer> inputWinningNumbers() {
        printWinningNumberMessage();
        String winningNumbers = Console.readLine();
        validateSeparator(winningNumbers);
        return changeStringToList(winningNumbers);
    }

    public void validateNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
    }

    public void validateSeparator(String input) {
        final String REGEX = "^\\d,\\d,\\d,\\d,\\d,\\d$";
        if (!Pattern.matches(REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표(,)로 구분하여 입력하세요.");
        }
    }

    public List<Integer> changeStringToList(String input) {
        List<Integer> result = new ArrayList<>();
        final String SEPARATOR = ",";
        String[] splitInput = input.split(SEPARATOR);
        for (int i = 0; i < splitInput.length; i++) {
            result.add(Integer.valueOf(splitInput[i]));
        }
        return result;
    }

    private void printPaymentMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}