package lotto.view;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberView {

    public static List<Integer> getWinNumbers() {
        List<Integer> winNumbers;
        System.out.println("당첨 번호를 입력해 주세요.");
        winNumbers = getWinNumbersFormat(readLine());
        checkWinNumbers(winNumbers);
        return winNumbers;
    }
    private static List<Integer> getWinNumbersFormat(String input) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            for (String num : input.split(",")) {
                result.add(Integer.valueOf(num));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉽표(,)로 구분해주세요.");
        }

        return result;
    }
    private static void checkWinNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 당첨번호는 6개입니다.");
        }
        Set set = new HashSet<Integer>(winNumbers);
        if (set.size() != winNumbers.size()) {
            throw new IllegalArgumentException("[Error] 당첨번호는 중복될 수 없습니다.");
        }
        for (int num : winNumbers) {
            if (num > 45) {
                throw new IllegalArgumentException("[Error] 당첨번호의 범위는 1~45 입니다.");
            }
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        return bonusNumber;
    }

    private void checkBonusNumber() {
    }
}
