package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;
    public User() {
    }

    public void inputMoney() {
        String inputMoneyString = Console.readLine();

        try {
            this.money = Integer.parseInt(inputMoneyString);
            checkInputMoney(this.money);
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력이 들어왔습니다.");
        }
    }

    private static void checkInputMoney(int userMoney) {
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return this.money;
    }
}
