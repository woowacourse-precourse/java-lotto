package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Buy {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_MESSAGE2 = "[ERROR] 천원 단위로 입력하세요";

    public static int isRightNumber(String money) {
        int returnMoney =0;
        try {
            returnMoney = Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            e.getMessage();
        }

        return returnMoney;
    }

    public static int buyLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE2);
        }

        int count = money / 1000;
        return count;
    }

    public static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        System.out.println(numbers);
        return lotto;
    }
}
