package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final String DELIMITER = ",";
    private static final int INVALID = -1;

    private Input() {}

    public static long inputMoney() {
        Message.INPUT_MONEY.print();
        String str = Console.readLine().trim();
        try {
            Validation.validateMoney(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return INVALID;
        }
        return Long.parseLong(str);
    }

    public static List<Integer> inputLotto() {
        Message.INPUT_LOTTERY_NUMBER.print();
        String str = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        String[] splitStr = str.split(DELIMITER);
        try {
            for (String s : splitStr) {
                Validation.validateNumber(s.trim());
                numbers.add(Integer.parseInt(s.trim()));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return numbers;
    }

    public static int inputBonus() {
        Message.INPUT_BONUS_NUMBER.print();
        String str = Console.readLine().trim();
        try {
            Validation.validateNumber(str);
            Validation.validateRange(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return INVALID;
        }
        return Integer.parseInt(str);
    }
}
