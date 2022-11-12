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
}
