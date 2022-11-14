package lotto;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(InputView.lottoStart());
        LottoTickets lottoTickets = lotto.generateLottoTickets();
        OutputView.lottoStatus(lottoTickets);
        WinningNumber winningNumber = lotto.generateWinningNumber(InputView.winningNumber());
        OutputView.LottoEnd(new LottoResult(lottoTickets.getLottoTickets(), winningNumber));
    }
}
