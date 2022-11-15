package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    public static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_MONEY_MULTIPLE_THOUSAND = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";
    public static final String PURCHASE_MONEY_MORE_THAN_ZERO = "[ERROR] 구입 금액은 양수여야 합니다.";

    int money;
    List<Lotto> myLotto;

    public void inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
        String money_str = Console.readLine();
        checkThatPurchaseMoneyIsRightInput(money_str);
    }

    public void checkThatPurchaseMoneyIsRightInput(String purchaseMoney){
        money = Exception.isInteger(purchaseMoney);

        checkThatPurchaseMoneyIsNotPositive();
        checkThatPurchaseMoneyIsNotMultipleOfThousand();
    }

    private void checkThatPurchaseMoneyIsNotPositive() throws IllegalArgumentException{
        if (Exception.isNotPositive(money)) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MORE_THAN_ZERO);
        }
    }

    private void checkThatPurchaseMoneyIsNotMultipleOfThousand() throws IllegalArgumentException{
        if (Exception.isNotMultipleOfThousand(money)) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MULTIPLE_THOUSAND);
        }
    }

    public void purchaseLotto() {
        int number = money / 1000;

        System.out.println(number + "개를 구매했습니다.");
        makeMyLotto(number);
    }

    public void makeMyLotto(int number) {
        for (int i = 0; i < number; i++) {
            List<Integer> lotto = getOneLotto();
            myLotto.add(new Lotto(lotto));
            System.out.println(lotto);
        }
    }

    public List<Integer> getOneLotto() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);

        return lotto;
    }
}