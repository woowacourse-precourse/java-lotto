package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    private int userMoney;
    private List<Integer> winningNumbers;
    private int bonusNumber;


    public User(int userMoney, List<Integer> winningNumbers, int bonusNumber) {
        this.userMoney = userMoney;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY);

        int money = Integer.parseInt(Console.readLine());
        return money;
    }
}
