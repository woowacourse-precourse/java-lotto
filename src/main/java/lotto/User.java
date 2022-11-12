package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    String money_str;
    int money;

    public void inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money_str = Console.readLine();
        checkThatPurchaseMoneyIsRightInput(money_str);
    }

    public void checkThatPurchaseMoneyIsRightInput(String purchaseMoney) {
        money = Exception.isInteger(purchaseMoney);

        if (Exception.isNotMultipleOfThousand(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        if (Exception.isNotPositive(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    public void purchaseLotto() {
        List<Lotto> myLotto = new ArrayList<>();
        int number = money / 1000;

        System.out.println("\n" + number + "개를 구매했습니다.");


        for (int i = 0; i < number; i++) {
            myLotto.add(new Lotto(getOneLotto()));
            System.out.println(getOneLotto());
        }
    }

    public List<Integer> getOneLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);

        return lotto;
    }
}