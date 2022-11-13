package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lottery {

    private final List<Lotto> lotteryNumbers;

    public Lottery(int purchaseAmount) {
        this.lotteryNumbers = makeLotteryNumbers(purchaseAmount);
    }

    public List<Lotto> getLotteryNumbers() {
        return lotteryNumbers;
    }

    private List<Lotto> makeLotteryNumbers(int size) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> unmodifiableList = Collections.unmodifiableList(numbers);
            List<Integer> newList = new ArrayList<>(unmodifiableList);
            Collections.sort(newList);
            Lotto lotto = new Lotto(newList);
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }
}
