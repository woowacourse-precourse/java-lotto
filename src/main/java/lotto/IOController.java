package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IOController {
    public static int readBuyingMoney() {
        String input = Console.readLine();
        int buyingMoney;
        try {
            buyingMoney = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자입니다.");
        }
        if (buyingMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위입니다.");
        }
        return buyingMoney / 1000;
    }
}
