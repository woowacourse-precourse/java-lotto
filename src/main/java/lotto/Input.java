package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final String DELIMITER = ",";

    private Input() {}

    public static boolean inputMoney() {
        String str = Console.readLine().trim();
        try {
            Validation.validateMoney(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static List<Integer> inputLotto() {
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
}
