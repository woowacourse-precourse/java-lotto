package user;

import camp.nextstep.edu.missionutils.Console;

import static message.ErrorMessage.INVALID_NUMBER;

public class InputMoney {
    private int money;

    public InputMoney(int money) {
        try {
            this.money = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER.getStatus());
        }
    }

    public int getMoney() {
        return money;
    }
}
