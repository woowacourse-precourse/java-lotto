package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LotteryMachine {

    public List<Lotto> generateLotteries(int numberOfLotteries) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < numberOfLotteries; ++i) {
            List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteryNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(lotteryNumbers);
            lotteries.add(lotto);
        }
        return lotteries;
    }
}
