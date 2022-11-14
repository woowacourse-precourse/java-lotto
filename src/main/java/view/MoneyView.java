package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class MoneyView {

    public Money show() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();
        validate(money);
        return new Money(Integer.parseInt(money));
    }

    private void validate(String money) {
        try {
            Integer.parseInt(money);
        }catch (Exception e) {
            throw new IllegalArgumentException("[Error] 구매금액은 정수형태이어야 합니다.");
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
