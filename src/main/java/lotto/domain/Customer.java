package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

    private static final String INPUT_MONEY = "구입 금액을 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final int REMAINDER = 0;

    private int money;
    private int hasLotto;

    public void payMoney() {
        try {
            System.out.println(INPUT_MONEY);
            this.money = Integer.parseInt(Console.readLine());

            if ((getMoney() % LOTTO_PRICE) != REMAINDER) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 급액은 1,000원 단위로 입력하시오.");
        }
    }

    public int getMoney() {
        return money;
    }

    public void buyLotto() {
        hasLotto = getMoney() / LOTTO_PRICE;
    }

    public int getHasLotto() {
        return hasLotto;
    }


}
