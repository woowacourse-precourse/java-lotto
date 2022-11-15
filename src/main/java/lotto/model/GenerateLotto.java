package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GenerateLotto {
    private static List<Lotto> lottoTickets = new ArrayList<>();
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
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_SIZE);
    }
    public List<Lotto> getLotto() {
        return lottoTickets;
    }
}
