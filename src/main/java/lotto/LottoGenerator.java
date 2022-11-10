package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator instance;

    private LottoGenerator() {
    }

    public LottoGenerator getInstance() {
        if (instance == null) {
            this.instance = new LottoGenerator();
        }
        return this.instance;

    }

    public List<Lotto> generatLottos(int money) {
        if (isNotDivisible(money)) {
            throw new IllegalArgumentException("[ERROR]isNotDivisibleBy1000");
        }

        List<Lotto> lottos = new ArrayList<>();
        int issueCount = getIssueCount(money);
        for (int count = 1; count <= issueCount; count++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private boolean isNotDivisible(int money) {
        return money <= 0 || money % 1000 != 0;
    }

    private int getIssueCount(int money) {
        return money / 1000;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                (LottoNumber.MIN, LottoNumber.MAX, LottoNumber.TOTAL_COUNT);
        return new Lotto(numbers);
    }


}
