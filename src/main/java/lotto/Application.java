package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String myMoney = Console.readLine();
        MyMoney money = new MyMoney(myMoney);
        System.out.println();
        return money.getAmount();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchase = inputMoney();

    }
}

