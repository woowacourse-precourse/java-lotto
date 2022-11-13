package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int money() {
        System.out.println("구입금액을 입력해 주세요");
        String money_input = Console.readLine();
        int money = Integer.MAX_VALUE;
        try {
            money = Integer.parseInt(money_input);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error]" + e.getMessage());
            throw e;
        }
        return money;
    }

    public int num_lotto(int money) {
        int num = 0;
        num = money / 1000 ;
        if (money % 1000 != 0) {
            System.out.println("[Error]1,000 단위의 금액을 입력하세요");
            throw new IllegalArgumentException();
        }
        System.out.println(num +"개를 구입했습니다.");
        return num;
    }

    public List<Integer> lotto() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        return lotto;
    }

}
