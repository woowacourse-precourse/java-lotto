package lotto;

public class LottoSystem {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoManager lottoManager = new LottoManager();
    CalculatorUtility calculatorUtility = new CalculatorUtility();

    public void start() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        LottoTickets lottoTickets = lottoBuyer.buyLotto(inputView, lottoManager);
        outputView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = lottoManager.generateWinningLotto(inputView.inputWinningNumbers());
        BonusBall bonusBall = lottoManager.generateBonusBall(inputView.inputBonusNumber());

        WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLotto, bonusBall);
        outputView.printWinningStatistics(winningStatistics.getWinningCountStatistics());

        ProfitRate profitRate = calculatorUtility.calculateProfitRate(winningStatistics, lottoBuyer);
        outputView.printTotalProfitRate(profitRate);
    }
}
