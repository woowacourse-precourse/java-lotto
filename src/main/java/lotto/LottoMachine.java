package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    List<List<Integer>> issueLotto;

    public LottoMachine() {
        this.issueLotto = new ArrayList<>();
    }

    public List<List<Integer>> issueLotto(int amount) {
        int number = amount / 1000;

        System.out.println(number + "개를 구매했습니다.");

        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            issueLotto.add(numbers);
            System.out.println(numbers.toString());
        }

        return issueLotto;
    }
}
