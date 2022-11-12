package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoUI {
    public static Integer purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        final String input = Console.readLine();
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    public static void numberOfLottoPurchased(final int num) {
        System.out.printf("%d개를 구매했습니다.", num);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}