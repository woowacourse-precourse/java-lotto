package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static LottoGenerator instance;

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        if (instance == null) {
            instance = new LottoGenerator();
        }
        return instance;
    }

    public Lottos generateLottos(int money) {
        if (isNotDivisible(money)) {
            throw new IllegalArgumentException("구입 금액은 로또 가격의 배수여야 합니다");
        }

        List<Lotto> lottos = new ArrayList<>();
        int issueCount = getIssueCount(money);
        for (int count = 1; count <= issueCount; count++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private boolean isNotDivisible(int money) {
        return money <= 0 || money % LottoRule.TICKET_COST != 0;
    }

    private int getIssueCount(int money) {
        return money / LottoRule.TICKET_COST;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                (LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER, LottoRule.TOTAL_COUNT);
        return new Lotto(numbers);
    }


}
