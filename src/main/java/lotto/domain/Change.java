package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    private static final String REGEX = "[0-9]+";

    public static List<Integer> lottoNumber(String winningNumber) {
        checkAnyWord(winningNumber);
        checkManyDot(winningNumber);
        checkFirstWord(winningNumber);
        checkLastWord(winningNumber);
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
                throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - ,2개");
            }
        }
    }

    private static void checkAnyWord(String winningNumber) {
        if (!(winningNumber.matches(REGEX) || winningNumber.contains(","))) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - 유효하지 않은 문자 입력");
        }
    }

    private static void checkFirstWord(String winningNumber) {
        if (!String.valueOf(winningNumber.charAt(0)).matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - 첫번째에 문자 입력");
        }
    }

    private static void checkLastWord(String winningNumber) {
        if (!String.valueOf(winningNumber.charAt(winningNumber.length() - 1)).matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - 마지막에 문자 입력");
        }
    }

    public static int number(String purchaseAmount) {
        checkWord(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private static void checkWord(String purchaseAmount){
        if (!purchaseAmount.matches(REGEX)){
            throw new IllegalArgumentException("[ERROR] 구입금액을 다시 입력해주세요. - 문자 포함");
        }
    }

    public static int bonusNumber(String bonusNumber){
        return Integer.parseInt(bonusNumber);
    }
}
