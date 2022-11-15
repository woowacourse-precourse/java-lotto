package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Ui {

    /**
     * 구입금액 입력 문구을 출력하고 구입금액을 입력 받아 반환한다.
     * 숫자가 아니거나 1000으로 나누어 떨어지는 수가 아니라면 예외가 발생한다.
     *
     * @return 유효한 구입금액
     * @throws IllegalArgumentException
     */
    public static int inputPurchaseAmount() throws IllegalArgumentException {
        printPurchaseAmountInputStatement();
        String input = inputString();
        throwExceptionIfNotNumber(input);
        int purchaseAmount = Integer.parseInt(input);
        throwExceptionIfNotDivisibleBy1000(purchaseAmount);
        return purchaseAmount;
    }

    private static void printPurchaseAmountInputStatement() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static String inputString() {
        return Console.readLine();
    }

    private static void throwExceptionIfNotNumber(String str) throws IllegalArgumentException {
        if (!isAllNumber(str)) {
            throw new IllegalArgumentException("[ERROR]: 구입금액은 숫자만 입력이 가능합니다.");
        }
    }

    private static boolean isAllNumber(String str) {
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!isNumber(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(char ch) {
        if (ch < '0' || '9' < ch) {
            return false;
        }
        return true;
    }

    private static void throwExceptionIfNotDivisibleBy1000(int number) throws IllegalArgumentException {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]: 구입금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}
