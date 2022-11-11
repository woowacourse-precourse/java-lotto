package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Player {

    private final List<Integer> playerNumbers;

    public Player() {
        this.playerNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> get() {
        return playerNumbers;
    }
}
