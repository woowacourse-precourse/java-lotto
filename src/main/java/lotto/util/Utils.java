package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Utils {
    public static int stringToIntMoney(String money) {
        return Integer.parseInt(money);
    }

    public static String readConsole() {
        return Console.readLine();
    }

    public static List<Integer> getIntegerList(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static boolean isContain(Integer checkNumber, List<Integer> numbers, int point) {
        for (int index = point + 1; index < numbers.size(); index++) {
            if (checkNumber.equals(numbers.get(index))) {
                return true;
            }
        }

        return false;
    }
}
