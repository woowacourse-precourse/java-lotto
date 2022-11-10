package lotto.global.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.view.OutputView;

import java.util.*;

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

    public static List<Integer> inputNumbersInList() {
        String inputPrizeNumbers = OutputView.printInputPrizeNumbers();
        return splitByComma(inputPrizeNumbers);
    }

    private static List<Integer> splitByComma(String inputPrizeNumbers) {
        StringTokenizer st = new StringTokenizer(inputPrizeNumbers, ",");
        int cnt = st.countTokens();
        return addListByTokens(st, cnt);
    }

    private static List<Integer> addListByTokens(StringTokenizer st, int cnt) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            inputNumbers.add(Integer.valueOf(st.nextToken()));
        }
        return inputNumbers;
    }
}
