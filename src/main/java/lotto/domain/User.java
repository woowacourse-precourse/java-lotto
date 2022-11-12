package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        boolean chkPrice = price.matches("-?\\d+");
        if (!chkPrice) {
            new Exceptions();
        }
        return Integer.parseInt(price);
    }

    public int countLotto(int price) {
        int countLotto = 0;
        if (price % 1000 > 0) {
            new Exceptions();
        }
        countLotto = price / 1000;
        return countLotto;
    }

    public List<Integer> makeLotto() {
        List<Integer> makeLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(makeLotto);
        return makeLotto;
    }

    public List<List<Integer>> showLotto(int countLotto) {
        List<List<Integer>> userLotto = new ArrayList<>();
        System.out.println(countLotto + "개를 구매했습니다.");
        for (int i = 0; i < countLotto; i++) {
            List<Integer> list = makeLotto();
            System.out.println(list);
            userLotto.add(list);
        }
        return userLotto;
    }
}
