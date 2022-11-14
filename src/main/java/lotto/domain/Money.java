package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.domain.AdditionalFunction.StringToInt;

public class Money {
    private final int money;

    public Money() {
        String inputMoney = Console.readLine();
        int verifyMoney = StringToInt(inputMoney);
        validateUnit(verifyMoney);
        validatePositiveNum(verifyMoney);
        this.money = verifyMoney;
    }

    public int getMoney(){
        return this.money;
    }

    private void validatePositiveNum(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 0원 이상의 금액을 입력하세요.");
        }
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력해야 합니다.");
        }
    }
}
