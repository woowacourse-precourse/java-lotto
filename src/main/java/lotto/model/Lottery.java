package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lottery {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private final List<Lotto> lotteryNumbers;

    public Lottery(int purchaseAmount) {
        this.lotteryNumbers = makeLotteryNumbers(purchaseAmount);
    }

    public List<Lotto> getLotteryNumbers() {
        return lotteryNumbers;
    }

    private List<Lotto> makeLotteryNumbers(int amount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, LOTTO_SIZE);
            List<Integer> unmodifiableList = Collections.unmodifiableList(numbers);
            List<Integer> newList = new ArrayList<>(unmodifiableList);
            Collections.sort(newList);
            Lotto lotto = new Lotto(newList);
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }
}
