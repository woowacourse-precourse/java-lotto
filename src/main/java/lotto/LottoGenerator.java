package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public LottoTickets generateLottoTickets(int numberOfLottoTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> random = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            lottoTickets.add(new Lotto(random));
        }
        return new LottoTickets(lottoTickets);
    }

    public WinningTicket generateWinningTicket(List<Integer> winningNumber, int bonus) {
        return new WinningTicket(winningNumber, bonus);
    }
}
