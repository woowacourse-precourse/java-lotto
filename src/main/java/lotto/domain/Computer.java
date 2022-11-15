package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Lotto> getLottoGames(int count) {
        List<Lotto> games = new ArrayList<>();

        while(count > 0) {
            games.add(new Lotto(generateLottoNumbers()));
            count--;
        }

        return games;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
