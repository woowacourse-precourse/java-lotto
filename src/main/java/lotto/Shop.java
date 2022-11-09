package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Shop {

    public static void purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        getMoney();
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static int getMoney() {
        int money;

        try {
            money = Integer.parseInt(getInput());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
        }

        validate(money);

        return money;
    }

    private static void validate(int money) {
        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 나뉘지 않습니다");
        }
    }
}
