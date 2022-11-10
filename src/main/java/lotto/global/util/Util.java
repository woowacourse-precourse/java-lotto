package lotto.global.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Util {

    public static String input() {
        return Console.readLine();
    }

    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> orderByDescForList(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
