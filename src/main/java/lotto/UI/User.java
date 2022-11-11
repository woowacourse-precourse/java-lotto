package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static Integer askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 문자 또는 공백은 입력이 불가능 합니다. 1,000원 단위의 숫자를 입력해 주세요.");
        }
    }

    public static boolean checkMonetaryUnit(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자를 입력해 주세요.");
        }
        return true;
    }

}