package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Buy {

    public static int isRightMoney(String money) {
        char[] splitMoney = money.toCharArray();
        for(int i=0; i<splitMoney.length; i++) {
            if(!Character.isDigit(splitMoney[i])) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
            }
        }
        return Integer.parseInt(money);
    }

    public static int buyLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력되어야 합니다.");
        }

        int count = money / 1000;
        return count;
    }

    public static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        System.out.println(numbers.toString());
        return lotto;
    }
}
