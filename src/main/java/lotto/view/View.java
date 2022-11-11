package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public int intputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력금액은 1000원 단위여야 합니다.");
        }
    }

}
