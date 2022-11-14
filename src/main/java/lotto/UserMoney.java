package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserMoney {
    private static final String ERROR_LOTTO_THOUSAND = "[ERROR] 1000원 단위로 입력해주세요.";
    public int getUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        moneyCheck(checkInt(money));

        return Integer.parseInt(money);
    }

    private int checkInt(String money) {

        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionCode.Not_Money.message);
        }
    }

    private void moneyCheck(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionCode.Not_Money.message);
        }
        if (money < 0) {
            throw new IllegalArgumentException(ExceptionCode.Over_Money.message);
        }
    }
}
