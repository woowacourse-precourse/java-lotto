package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    private static final String REGEX = "[0-9]+";

    public static List<Integer> lottoNumber(String winningNumber) {
        checkAnyWord(winningNumber);
        checkManyDot(winningNumber);
        checkFirstWord(winningNumber);
        List<String> newWinningNumber = Arrays.asList(winningNumber.split(","));
        List<Integer> result = new ArrayList<>();
        for (String number : newWinningNumber) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private static void checkManyDot(String winningNumber) {
        int dotCount = 0;
        for (int i = 0; i < winningNumber.length(); i++) {
            if (!(winningNumber.charAt(i) == ',')) {
                dotCount = 0;
                continue;
            }
            dotCount++;
            if (dotCount >= 2) {
                System.out.println("[ERROR] 당첨번호를 다시 입력해주세요. - ,2개");
                throw new IllegalArgumentException();
            }

        }
    }

    private static void checkAnyWord(String winningNumber) {
        if (!(winningNumber.matches(REGEX) || winningNumber.contains(","))) {
            System.out.println("[ERROR] 당첨번호를 다시 입력해주세요. - 유효하지 않은 문자 입력");
            throw new IllegalArgumentException();
        }
    }

    private static void checkFirstWord(String winningNumber) {
        if (!String.valueOf(winningNumber.charAt(0)).matches(REGEX)){
            System.out.println("[ERROR] 당첨번호를 다시 입력해주세요. - 첫번째에 문자 입력");
            throw new IllegalArgumentException();
        }
    }
}
