package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final static int LOTTO_NUMBER_LENGTH = 6;
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    public List<Lotto> createLottoTickets(int money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int createLottoNumber = money / 1000;
        for (int i = 0; i < createLottoNumber; i++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE, LOTTO_NUMBER_LENGTH)
        );
    }
}
