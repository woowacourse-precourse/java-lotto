package ui;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Constants.*;

public class Input {
    public static int inputSeedMoney() {
        String assumeMoney = readLine();
        int money = convertStr2Int(assumeMoney);
        validateRangeOfMoney(money);
        return money;
    }

    public static List<Integer> inputWinningNumbers() {
        String assumeWinningNumbers = readLine();
        String[] splitWinningNumbers = assumeWinningNumbers.split(SPLIT_MARK);
        return convertStrArr2IntList(splitWinningNumbers);
    }

    public static int inputBonusNumber() {
        String assumeBonus = readLine();
        return convertStr2Int(assumeBonus);
    }

    public static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public static void validateNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_IS_NOT_NUMERIC);
        }
    }

    public static int convertStr2Int(String input) {
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> convertStrArr2IntList(String[] strArr) {
        List<Integer> numbers = new ArrayList<>();
        for (String assumeNumber : strArr) {
            numbers.add(convertStr2Int(assumeNumber));
        }
        return numbers;
    }

    public static void validateRangeOfMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_PROPER_MONEY);
        }
    }
}
