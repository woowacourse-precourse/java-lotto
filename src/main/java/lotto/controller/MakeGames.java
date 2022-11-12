package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;

public class MakeGames {
    int gameCount;

    public MakeGames(int gameCount) {
        this.gameCount = gameCount;
    }

    public void makeGames(List<Lotto> games) {
        for (int i = 0; i < gameCount; i++) {
            games.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
