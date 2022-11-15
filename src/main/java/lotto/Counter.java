package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;

public class Counter {
    private int money;
    private int numberOfLotto;

    public Counter() {
        money = 0;
    }

    public void putMoney() {
        System.out.println(Message.EnterPurchasingAmountMessage);
        String inputMoney = Console.readLine();

        moneyCheck(inputMoney);
    }

    private void moneyCheck(String inputMoney) {
        numberCheck(inputMoney);
        money = Integer.parseInt(inputMoney);
        unitCheck(money);

        moneyCount(money);
    }

    public void numberCheck(String inputMoney) {
        try {
            Double.parseDouble(inputMoney);
        } catch (NumberFormatException e) {
            System.out.println(Message.IsNotNumberMessage);
            throw new IllegalArgumentException();
        }
    }

    public void unitCheck(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(Message.IsNotThousandUnitMessage);
        }
    }

    private void moneyCount(int money) {
        this.numberOfLotto = money / 1000;
    }

    public int getNumberOfLotto() {
        System.out.println(numberOfLotto + Message.PurchaseMessage);
        return numberOfLotto;
    }

    public int getMoney() {
        return money;
    }
}
