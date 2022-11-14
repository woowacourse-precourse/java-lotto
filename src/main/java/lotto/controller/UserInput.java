package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.Error.*;

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
}
