package lotto.view;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberView {
    private static List<Integer> winNumbers;

    public static List<Integer> getWinNumbers() {
        List<Integer> winNumbers;
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요. ex) 1,2,3,4,5,6");
        winNumbers = getWinNumbersFormat(readLine());
        checkWinNumbers(winNumbers);
        NumberView.winNumbers = winNumbers;
        return winNumbers;
    }

    private static List<Integer> getWinNumbersFormat(String input) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            for (String num : input.split(",")) {
                result.add(Integer.valueOf(num));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로만 입력 가능하며, 쉽표(,)로 구분해주세요.");
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
            checkRange(num);
        }
    }

    public static int getBonusNumber() {
        int bonusNumber;
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = checkBonusNumber(readLine());

        return bonusNumber;
    }

    private static int checkBonusNumber(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 숫자로만 입력 가능합니다.");
        }
        checkRange(result);
        if (winNumbers.contains(result)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return result;
    }

    private static void checkRange(int num) {
        if (num > 45) {
            throw new IllegalArgumentException("[Error] 로또 번호의 범위는 1~45 입니다.");
        }
    }
}
