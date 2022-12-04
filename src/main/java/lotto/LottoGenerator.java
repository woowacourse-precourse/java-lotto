package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String MINIMUM_TICKETS_ERROR = "[ERROR] 로또 개수가 1미만일 수는 없습니다.";

    public Lottos makeLottos(int lottoTickets) {
        checkPositive(lottoTickets);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> random = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_SIZE);
            lottos.add(new Lotto(random));
        }
        return new Lottos(lottos);
    }

    public WinningLotto makeLotto(List<Integer> winningNumber, int bonus) {
        return new WinningLotto(winningNumber, bonus);
    }

    private void checkPositive(int lottoTickets) {
        if (lottoTickets < 1) {
            throw new IllegalArgumentException(MINIMUM_TICKETS_ERROR);
        }
    }
}
