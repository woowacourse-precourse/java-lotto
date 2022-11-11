package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.view.OutputView;

public class Player {

    private final List<Integer> playerNumbers;

    public Player() {
        this.playerNumbers = createPlayerNumbers();
        OutputView.printPlayerNumbers(playerNumbers);
    }

    private static List<Integer> createPlayerNumbers() {
        return sortInAscendingOrders(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Integer> get() {
        return playerNumbers;
    }

    private static List<Integer> sortInAscendingOrders(List<Integer> playerNumbers) {
        Collections.sort(playerNumbers);
        return playerNumbers;
    }
}
