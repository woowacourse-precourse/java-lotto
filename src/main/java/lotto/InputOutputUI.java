package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

class InputOutputUI {
    private int money = 0;


    public void setMoney() {
        System.out.print("로또 구입 금액을 입력하세요 : ");
        int number=Integer.valueOf(Console.readLine());
        validate(number);
        money = number;
    }

    public int getMoney() {
        System.out.println(money/Constants.DIV_MONEY);
        return money/Constants.DIV_MONEY;
    }

    void validate(int number) {
        try {
            if (number % Constants.DIV_MONEY != 0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_DIV);
        }
    }
}

