package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator {
    public List<List<Integer>> createTicket(int ticketsCount) {
        List<List<Integer>> randomLotto = new ArrayList<>();

        for (int ticket = 0; ticket < ticketsCount; ticket++) {
            randomLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        lottoTheorem(randomLotto);
        return randomLotto;
    }

    private void lottoTheorem(List<List<Integer>> randomLotto) {
        for (List<Integer> randomNumber : randomLotto) {
            Collections.sort(randomNumber);
        }
    }
}