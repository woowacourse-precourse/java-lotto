package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoVendingMachine {
    private List<Lotto> lottoBundle;
    private int money;
    private int pieces;

    public void inputMoney() {
        String temp;
        System.out.println("구입금액을 입력해 주세요.");
        temp = Console.readLine();
            money = Integer.parseInt(temp);
            pieces = money/1000;
    }
}


