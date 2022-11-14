package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.util.RandomUtil;
import lotto.util.constants.LottoConstants;
import lotto.util.constants.WinningScore;

public class LottoMachine {
    private LottoResult lottoResult;
    private Winning winning;

    public void createWinningLotto(Lotto lotto, int bonusNumber) {
        winning = new Winning(lotto, bonusNumber);
        lottoResult = new LottoResult();
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

    public Map<WinningScore, Integer> computeWinningResults(List<Lotto> userLottoTickets) {
        Lotto winningLotto = winning.getWinningLotto();
        return lottoResult.computeWinningScore(userLottoTickets, winningLotto);
    }

}
