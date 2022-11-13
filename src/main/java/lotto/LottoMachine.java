package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoMachine {
    private final List<Integer> normalNumber;
    private final int bonusNumber;

    public LottoMachine(List<Integer> normalNumber, int bonusNumber) {
        this.normalNumber = normalNumber;
        this.bonusNumber = bonusNumber;
    }

    public String getMoney() {
        System.out.println("구매금액을 입력해주세요.");
        String money = Console.readLine();
        return money;
    }

}
