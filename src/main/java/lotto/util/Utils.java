package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int convertToInt(String money) {
        return Integer.parseInt(money);
    }

    public static List<Integer> convertToList(String numbers) {
        List<Integer> numbersList = new ArrayList<>();
        String number = "";
        for (int index = 0; index < numbers.length(); index++) {
            char checkChar = numbers.charAt(index);
            if ((checkChar == ',')) {
                numbersList.add(Utils.convertToInt(number));
                number = "";
                continue;
            }
            number = number + checkChar;
        }
        numbersList.add(Utils.convertToInt(number));

        return numbersList;
    }

    public static String readConsole() {
        return Console.readLine();
    }

    public static ArrayList<Integer> getIntegerList(int start, int end, int count) {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(start, end, count));
    }

    public static boolean isContain(Integer checkNumber, List<Integer> numbers, int point) {
        for (int index = point + 1; index < numbers.size(); index++) {
            if (checkNumber.equals(numbers.get(index))) {
                return true;
            }
        }

        return false;
    }

    public static boolean isContain(String checkNumber, List<Integer> numbers) {
        int bonusNumber = Integer.parseInt(checkNumber);

        for (int index = 0; index < numbers.size(); index++) {
            if (bonusNumber == numbers.get(index)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isContain(int checkNumber, List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (checkNumber == numbers.get(index)) {
                return true;
            }
        }

        return false;
    }
}
