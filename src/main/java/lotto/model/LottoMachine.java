package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomUtil;
import lotto.util.constants.LottoConstants;

public class LottoMachine {
    private Winning winning;

    public void createWinningLotto(Lotto lotto, int bonusNumber) {
        winning = new Winning(lotto, bonusNumber);
    }

    public int computeLottoTicketsCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_TICKET_PRICE;
    }

    public List<Lotto> publishLottoTickets(int countLottoTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int ticketCount = 0; ticketCount < countLottoTickets; ticketCount++) {
            Lotto lottoTicket = createLottoTicket();
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    public Lotto createLottoTicket() {
        RandomUtil lottoRandom = new RandomUtil();
        return new Lotto(lottoRandom.pickNumbers());
    }

    public int compareLottoNumber(List<Integer> userLotto, List<Integer> winningLotto) {
        return (int) userLotto.stream().filter(num -> winningLotto.contains(num)).count();
    }
}
