package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        int lottoCount = getLottoCount(Console.readLine());
    }

    public static int getLottoCount(String string) {
        if (!isNumber(string)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 숫자 형식이 아닙니다.");
        }

        int number = Integer.parseInt(string);

        if (!isPositiveNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 양수가 아닙니다.");
        }

        if (!isDividedBy1000(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 1,000원으로 나누어떨어지지 않습니다.");
        }

        return number / 1000;
    }

    private static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositiveNumber(int number) {
        return number > 0;
    }

    private static boolean isDividedBy1000(int number) {
        return number / 1000 == 0;
    }
}
