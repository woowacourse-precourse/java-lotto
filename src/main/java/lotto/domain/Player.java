package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR = "[ERROR] 숫자가 아닌 값이 있습니다.";

    public static int getMoney() {
        System.out.println(GET_MONEY_MESSAGE);
        return getNumber();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(GET_WINNING_NUMBERS_MESSAGE);
        return getNumbers();
    }

    public static int getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return getNumber();
    }

    private static void isNumber(String word) {
        for (int index = 0; index < word.length(); index++) {
            char letter = word.charAt(index);
            if (index == 0 && letter == '0') {
                throw new IllegalArgumentException();
            }
            if (!Character.isDigit(letter)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int getNumber() {
        String line = Console.readLine();
        try {
            isNumber(line);
        } catch (Exception e) {
            System.out.println(NUMBER_ERROR);
            return 0;
        }
        return Integer.parseInt(line);
    }

    private static List<Integer> getNumbers() {
        String line = Console.readLine();
        String[] components = line.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String component : components) {
            try {
                isNumber(component);
            } catch (Exception e) {
                System.out.println(NUMBER_ERROR);
                return null;
            }
            int number = Integer.parseInt(component);
            numbers.add(number);
        }
        return numbers;
    }
}
