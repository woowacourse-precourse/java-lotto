package lotto;

import lotto.domain.winning.LottoTickets;
import lotto.domain.winning.WinningLotto;
import lotto.service.LottoService;
import lotto.service.FinalResultsDto;
import lotto.view.input.LottoScanner;
import lotto.view.output.LottoPrinter;

public class LottoGame {

    private final LottoService lottoService;
    private final LottoScanner lottoScanner;
    private final LottoPrinter lottoPrinter;

    public LottoGame(LottoService lottoService, LottoScanner lottoScanner,
            LottoPrinter lottoPrinter) {
        this.lottoService = lottoService;
        this.lottoScanner = lottoScanner;
        this.lottoPrinter = lottoPrinter;
    }

    public void start() {
        try {
            String money = money();
            LottoTickets lottoTickets = lottoTickets(money);

            WinningLotto winningLotto = lottoService.winningLotto(
                    winningNumber(),
                    bonusNumber());

            makeFinalResults(lottoTickets, winningLotto);
        } catch (IllegalArgumentException e) {
            lottoPrinter.printErrorMessage(e.getMessage());
        }
    }

    private String money() {
        lottoPrinter.printGuideMessageForPurchase();
        return lottoScanner.number();
    }

    private LottoTickets lottoTickets(String money) {
        LottoTickets lottoTickets = lottoService.lottoTickets(money);
        lottoPrinter.printLottoTickets(lottoTickets);

        return lottoTickets;
    }

    private String winningNumber() {
        lottoPrinter.printGuideMessageForWinningNumber();
        return lottoScanner.formattedNumber();
    }

    private String bonusNumber() {
        lottoPrinter.printGuideMessageForBonusNumber();
        return lottoScanner.number();
    }

    private void makeFinalResults(LottoTickets lottoTickets, WinningLotto winningLotto) {
        FinalResultsDto finalResultsDto = lottoService
                .finalResultsDto(lottoTickets, winningLotto);

        lottoPrinter.printFinalResults(finalResultsDto);
    }
}