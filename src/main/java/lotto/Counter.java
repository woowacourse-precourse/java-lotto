package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;

public class Counter {
    private int money;
    private int numberOfLotto;

    public Counter() {
        money = Message.ZEROINIT;
    }

    public void putMoney() {
        System.out.println(Message.EnterPurchasingAmountMessage);
        String inputMoney = Console.readLine();

        moneyCheck(inputMoney);
    }

    private void moneyCheck(String inputMoney) {
        numberCheck(inputMoney);
        unitCheck(money);
        moneyCount(money);
    }

    public void numberCheck(String inputMoney) {
        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.IsNotNumberMessage);
        }
    }

    public void unitCheck(int money) {
        if (money % Message.THOUSAND != Message.ZERO) {
            throw new IllegalArgumentException(Message.IsNotThousandUnitMessage);
        }
    }

    private void moneyCount(int money) {
        this.numberOfLotto = money / Message.THOUSAND;
    }

    public int getNumberOfLotto() {
        System.out.println(numberOfLotto + Message.PurchaseMessage);
        return numberOfLotto;
    }

    public int getMoney() {
        return money;
    }
}
