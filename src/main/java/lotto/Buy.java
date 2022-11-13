package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Buy {
    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        if(money%1000!=0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력되어야 합니다.");
        }

        int count = money/1000;
        return count;
    }
}
