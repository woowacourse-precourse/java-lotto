package lotto.buyLotto;

import camp.nextstep.edu.missionutils.Console;

public class GetMoney {
    public int getMoneyFromUser() {
        try {
            int money = Integer.parseInt(Console.readLine());
            if (!(money % 1000 == 0)) {
                throw new IllegalArgumentException();
            }
            return money / 1000;
        } catch (Exception e) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
}
