package lotto.domain;

import lotto.dto.LottoGameResultDto;

public class LottoGame {
    private final Customer customer;
    private final LottoTicket lottoTicket;

    public LottoGame(Customer customer) {
        this.customer = customer;
        this.lottoTicket = generateLottoTicket(customer);
    }

    private LottoTicket generateLottoTicket(Customer customer) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generate(customer.getBuyLottoQuantity());
    }

    public WinningLotto generateWinningLotto(String winningLotto) {
        return new WinningLotto(winningLotto);
    }

    public BonusNumber generateBonusNumber(String bonusNumber, WinningLotto winningLotto) {
        return new BonusNumber(bonusNumber, winningLotto);
    }

    public LottoGameResultDto play(WinningLotto winningLotto, BonusNumber bonusNumber) {
        LottoTicketsResult lottoTicketsResult = generateLottoTicketsResult(winningLotto, bonusNumber);
        Profit profit = generateProfit(lottoTicketsResult, customer.getMoney());
        return new LottoGameResultDto(lottoTicketsResult, profit);
    }

    private LottoTicketsResult generateLottoTicketsResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        LottoComparator lottoComparator = new LottoComparator(lottoTicket, winningLotto, bonusNumber);
        return lottoComparator.compare();
    }

    private Profit generateProfit(LottoTicketsResult lottoTicketsResult, Money money) {
        return new Profit(lottoTicketsResult, money);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
