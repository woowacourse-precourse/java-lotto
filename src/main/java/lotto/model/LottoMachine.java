package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.ErrorMessage;
import lotto.util.LottoConstants;
import lotto.util.RandomUtil;

public class LottoMachine {
    private final int purchaseAmount;
    private final int lottoTicketCount;
    private List<Lotto> lottoTickets;

    public LottoMachine(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoTicketCount = this.purchaseAmount / LottoConstants.LOTTO_PRICE_UNIT;
        publishLottoTickets();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    private void validate(int purchaseAmount) {
        if (!isDivisibleBy1000(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIVISIBLE_LOTTO);
        }
    }

    private boolean isDivisibleBy1000(int number) {
        return number % LottoConstants.LOTTO_PRICE_UNIT == 0;
    }

    private void publishLottoTickets() {
        lottoTickets = new ArrayList<>();
        for (int ticketCount = 0; ticketCount < lottoTicketCount; ticketCount++) {
            Lotto lottoTicket = createLottoTicket();
            lottoTickets.add(lottoTicket);
        }
    }

    private Lotto createLottoTicket() {
        return new Lotto(RandomUtil.pickNumbers());
    }

}
