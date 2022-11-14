package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static int writeBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        hasOnlyNumber(userInput);
        isStartedNotZero(userInput);

        int budget = Integer.valueOf(userInput);
        isDividableBy1000(budget);

        return budget;
    }

    public static List<Integer> writeWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        isValidInput(userInput);

        List<Integer> winningNumber = stringToNumbers(userInput);
        for (int lottoNumber: winningNumber) {
            validNumber(lottoNumber);
        }

        return winningNumber;
    }

    public static int writeBonusNumber(List<Integer> winningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        hasOnlyNumber(userInput);

        int bonusNumber = Integer.valueOf(userInput);
        validNumber(bonusNumber);
        hasSameNumber(bonusNumber, winningNumber);

        return bonusNumber;
    }

    private static List<Integer> stringToNumbers(String input) {
        String[] stringNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number: stringNumbers) {
            int lottoNumber = Integer.valueOf(number);
            hasSameNumber(lottoNumber, numbers);
            numbers.add(lottoNumber);
        }

        return numbers;
    }

    private static void hasOnlyNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void isValidInput(String input) {
        if (!input.matches("[0-9],[0-9],[0-9],[0-9],[0-9],[0-9]")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 쉼표만으로 구분하여 입력해야 합니다.");
        }
    }

    private static void isStartedNotZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0이 아닌 숫자로 시작해야 합니다");
        }
    }

    private static void isDividableBy1000(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private static void validNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."));
        }
    }

    private static void hasSameNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }
}
