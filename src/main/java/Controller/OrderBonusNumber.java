package Controller;

import camp.nextstep.edu.missionutils.Console;

public class OrderBonusNumber {
    private final String orderBonusNumber;

    public OrderBonusNumber() {
        this.orderBonusNumber = Console.readLine();
    }

    public String getLottoNumber() {
        return orderBonusNumber;
    }
}
