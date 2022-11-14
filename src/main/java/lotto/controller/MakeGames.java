package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
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
        Lotto lotto = new Lotto(sortNumber(numbers)); // 로또 번호를 오름차순으로 저장하기위해 솔트 해준다.
        return lotto;
    }
    private List<Integer> sortNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(numbers);
        Collections.sort(result);
        return result;
    }
}
