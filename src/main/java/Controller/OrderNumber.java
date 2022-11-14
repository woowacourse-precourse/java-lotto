package Controller;

import camp.nextstep.edu.missionutils.Console;

public class OrderNumber {
    private final String orderNumber;

    public OrderNumber() {
        this.orderNumber = Console.readLine();
    }

    public String getLottoNumber() {
        return orderNumber;
    }

}
