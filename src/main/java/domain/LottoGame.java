package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static java.util.Arrays.asList;

public class LottoGame {
    private final static int WIN = 0;
    private final static int SECOND = 0;
    private final static int THIRD = 0;
    private final static int FOURTH = 0;
    private final static int FIFTH = 0;

    private List<Lotto> lotteries;
    private List<Integer> matchCounts;

    public LottoGame() {
        lotteries = new ArrayList<>();
        matchCounts = new ArrayList<>(asList(0, 0, 0, 0, 0, 0, 0, 0)); // 0,1,2,3,4,5,6,bonus
    }

    public void createLotto(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            Lotto createdLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            addLotto(createdLotto);
        }
    }

    private void addLotto(Lotto lotto) {
        lotteries.add(lotto);
    }

    public void printLotteries(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            Lotto createdLotto = lotteries.get(i);
            createdLotto.printCreatedLotto();
        }
    }
}
