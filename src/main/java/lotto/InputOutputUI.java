package lotto;

import java.util.*;

class InputOutputUI {

    private int money = 0;


    public void setMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("로또 구입 금액을 입력하세요 : ");
        money = sc.nextInt();
        validate(money);
    }

    public int getMoney() {
        System.out.println(money);
        return money;
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

