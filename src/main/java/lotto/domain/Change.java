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

    private static void checkManyDot(String input) {
        int dotCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == ',')) {
                dotCount = 0;
                continue;
            }
            dotCount++;
            if (dotCount >= 2) {
                throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - ,2개");
            }
        }
    }

    private static void checkAnyWord(String input) {
        if (!(input.matches(REGEX) || input.contains(","))) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - 유효하지 않은 문자 입력");
        }
    }

    private static void checkFirstWord(String input) {
        if (!String.valueOf(input.charAt(0)).matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - 첫번째에 문자 입력");
        }
    }

    private static void checkLastWord(String input) {
        if (!String.valueOf(input.charAt(input.length() - 1)).matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 다시 입력해주세요. - 마지막에 문자 입력");
        }
    }

    public static int number(String purchaseAmount) {
        checkWord(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private static void checkWord(String input){
        if (!input.matches(REGEX)){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. - 문자 포함");
        }
    }

    public static int bonusNumber(String bonusNumber){
        checkWord(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
