package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberView {
    static Map map = new HashMap<Integer, Boolean>();

    public static List<Integer> getWinNumbers() {
        List<Integer> winNumbers;
        System.out.println("당첨 번호를 입력해 주세요.");
        winNumbers = getWinNumbersFormat(readLine());
        return winNumbers;
    }
    private static List<Integer> getWinNumbersFormat(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for (String num : input.split(",")) {
            result.add(Integer.valueOf(num));
        }
        return result;
    }
    private static List<Integer> checkWinNumbers(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for (String num : input.split(",")) {
            result.add(Integer.valueOf(num));
        }
        return result;
    }

    public static int getBonusNumber() {
        return 0;
    }

    private void checkBonusNumber() {
    }
}
