package lotto.system;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.money.Money;

public class RandomLottoSystem {
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer COUNT = 6;

    private final IoSystem io;

    public RandomLottoSystem(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    private List<List<Integer>> generateRandomNumbers(final Long repeatCount) {
        List<List<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < repeatCount; i++) {
            numbers.add(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT));
        }
        return numbers;
    }

    public LottoBundle generateLottoBundle(Money money) {
        var numbers = this.generateRandomNumbers(money.calculateAvailablePurchaseCount());

        io.println(numbers.size() + "개를 구매했습니다.");
        var lottoBundle = new LottoBundle(numbers);

        io.println(lottoBundle.listUpLotto());

        return lottoBundle;
    }

}
