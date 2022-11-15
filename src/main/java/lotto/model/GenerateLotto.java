package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLotto {
    private static List<Lotto> lottoTickets;
    private final int LOTTO_NUM_START = 1;
    private final int LOTTO_NUM_END = 45;
    private final int LOTTO_SIZE = 6;
    public GenerateLotto(int tickets) {
        lottoTickets = setLotto(tickets);
    }

    public List<Lotto> setLotto(int tickets) {
        List<Lotto> newLotto = new ArrayList<>();

        for(int i = 0; i < tickets; i++) {
            newLotto.add(new Lotto(getLottoNumbers()));
        }
        return newLotto;
    }
    public List<Integer> getLottoNumbers() {
        List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_SIZE);
        Collections.sort(newLotto);
        return newLotto;
    }
    public List<Lotto> getLotto() {
        return lottoTickets;
    }
}
