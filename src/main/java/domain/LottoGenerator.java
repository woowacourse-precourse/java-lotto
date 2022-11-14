package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public LottoTickets generateLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i=0; i<count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            lottoTickets.add(new Lotto(numbers));
        }
        return new LottoTickets(lottoTickets);
    }
}
