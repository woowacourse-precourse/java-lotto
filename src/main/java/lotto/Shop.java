package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Shop {
    private Integer money;
    private List<Lotto> lottos;

    public void inputMoney() {
        String money = Console.readLine();
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {

    }
}
