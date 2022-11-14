package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Input {
    private static int stringToInt(String input) {
        validNumber(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> toIntegerList(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : split) {
            numbers.add(stringToInt(str));
        }
        return numbers;
    }

    private static int getInput() {
        String input = Console.readLine();
        return stringToInt(input);
    }

    public static int getPurchaseAmount() {
        int input = getInput();
        validPurchase(input);
        return input;
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        validWinning6Numbers(split);
        validWinningRepetition(split);
        List<Integer> numbers = toIntegerList(split);
        valid1to45(numbers);
        return numbers;
    }

    public static int getBonusNumber(List<Integer> winning) {
        int input = getInput();
        validBonusRepetition(input, winning);
        valid1to45(input);
        return input;
    }

    private static void validNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 값이 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("[ERROR] 입력 값이 잘못되었습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validPurchase(int input) throws IllegalArgumentException {
        if (input % 1000 != 0) {
            System.out.println("[ERROR] 1000원으로 나누어지는 수가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validWinning6Numbers(String[] split) throws IllegalArgumentException {
        if (split.length != 6) {
            System.out.println("[ERROR] 쉼표로 구분된 6개의 문자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validWinningRepetition(String[] split) throws IllegalArgumentException {
        HashSet<String> removeDuplication = new HashSet<>(List.of(split));
        if (removeDuplication.size() != 6) {
            System.out.println("[ERROR] 중복되는 당첨 번호가 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validBonusRepetition(int bonus, List<Integer> winning) throws IllegalArgumentException {
        if (winning.contains(bonus)) {
            System.out.println("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void valid1to45(int number) throws IllegalArgumentException {
        if ((number > 45) || (number < 1)) {
            System.out.println("[ERROR] 숫자가 1에서 45 사이의 값이 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void valid1to45(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if ((number > 45) || (number < 1)) {
                System.out.println("[ERROR] 숫자가 1에서 45 값이 아닙니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
