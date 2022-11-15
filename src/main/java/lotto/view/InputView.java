package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static Integer getAmount(String input) {
        try {
            Integer amount = Integer.valueOf(input);
            if (amount % 1000 != 0 || amount <= 0) {
                System.out.println("[ERROR] 1000원 단위로 입력해주세요. ");
                throw new IllegalArgumentException();
            }
            return amount;
        } catch (NumberFormatException ex) {
            System.out.println("[ERROR] 금액을 정확히 입력해주세요. ");
            throw new NoSuchElementException();
        }
    }

    public static List<Integer> getWinningNumber(String input) {
        List<Integer> winningNumber = splitStringByComma(input);

        if (winningNumber.size() != 6) {
            System.out.println("[ERROR] 숫자 6개만 입력해주세요. ");
            throw new IllegalArgumentException();
        }
        for (Integer number : winningNumber) {
            validateInRange(number);
        }
        return winningNumber;
    }

    public static Integer getBonusNumber(String input) {
        try {
            Integer inputNumber = Integer.valueOf(input);
            validateInRange(inputNumber);
            return inputNumber;
        } catch (NumberFormatException ex) {
            System.out.println("[ERROR] 숫자가 아닌 값이 입력됐습니다. ");
            throw new IllegalArgumentException();
        }
    }

    public static Integer getAmount() {
        return getAmount(readLine());
    }

    public static List<Integer> getWinningNumber() {
        return getWinningNumber(readLine());
    }

    public static Integer getBonusNumber() {
        return getBonusNumber(readLine());
    }

    private static List<Integer> splitStringByComma(String string) {
        try {
            return Arrays.stream(string.split(","))
                    .map(number -> Integer.valueOf(number))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            System.out.println("[ERROR] 금액을 정확히 입력해주세요. ");
            throw new IllegalArgumentException();
        }
    }

    private static void validateInRange(Integer number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 1~45 사이의 값을 입력해주세요. ");
            throw new IllegalArgumentException();
        }
    }
}
