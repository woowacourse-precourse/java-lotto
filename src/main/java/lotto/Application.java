package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        int purchaseMoney;
        try {
            purchaseMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주시기 바랍니다.");
        }

        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }

        System.out.println(purchaseMoney/1000 + "개를 구매했습니다.");
    }
}
