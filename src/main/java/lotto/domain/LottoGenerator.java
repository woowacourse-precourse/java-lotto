package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static java.util.Collections.sort;

public class LottoGenerator {
    List<Integer> userNumbers;
    int count;

    public LottoGenerator(int money) {
        this.count = money / 1000;
    }

    public List<Integer> userLottoNumbers() {
        userNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(userNumbers);

        return userNumbers;
    }
}
