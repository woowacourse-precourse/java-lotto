package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import lotto.utils.Constant;

public class LottoGenerator {
    public LottoGenerator() {
        getSortedRandomLotto();
    }

    public List<Integer> getSortedRandomLotto() {
        return new ArrayList<>(sortRandomLotto());
    }

    private TreeSet<Integer> sortRandomLotto() {
        TreeSet<Integer> sortedRandomLotto = new TreeSet<>(generateRandomLotto());
        return sortedRandomLotto;
    }

    private List<Integer> generateRandomLotto() {
        List<Integer> randomLotto;
        randomLotto = Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER, Constant.LOTTO_SIZE);
        return randomLotto;
    }
}