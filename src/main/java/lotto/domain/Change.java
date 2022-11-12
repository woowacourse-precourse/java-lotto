package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {

    public static List<Integer> lottoNumber(String winningNumber) {
        checkManyDot(winningNumber);
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
}
