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
        String input = Console.readLine();
        return input;
    }

    public void validate(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
        }

        if(money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위가 아닙니다.");
        }
    }
}
