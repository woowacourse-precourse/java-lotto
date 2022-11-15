package lotto;

import static lotto.io.Message.ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Config;
import lotto.domain.BonusNumber;
import lotto.domain.IssuedLotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.StatResult;
import lotto.domain.WinningNumber;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;

public class LottoGame {

    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;

    private LottoGame(LottoIssueService lottoIssueService, StatisticsService statisticsService) {
        this.lottoIssueService = lottoIssueService;
        this.statisticsService = statisticsService;
    }

    public static void run() {
        try {
            Config config = new Config();

            LottoGame lottoGame = new LottoGame(config.lottoIssueService(), config.statisticsService());
            lottoGame.start();
        } catch (NumberFormatException e) {
            Writer.sendErrorMessage(ONLY_NUMBER);
        } catch (IllegalArgumentException e) {
            Writer.sendErrorMessage(e.getMessage());
        }
    }

    private void start() {
        IssuedLotto issuedLotto = this.issueLotto(this.inputPurchaseAmount());

        WinningNumber winningNumber = this.inputWinningNumber();
        BonusNumber bonusNumber = this.inputBonusNumber();

        printResult(issuedLotto, winningNumber, bonusNumber);
    }

    private void printResult(IssuedLotto issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        StatResult statResult = statisticsService.compileStatistics(issuedLotto, winningNumber, bonusNumber);
        Writer.printResult(statResult);
    }

    private PurchaseAmount inputPurchaseAmount() {
        Writer.inputPurchaseAmount();
        return new PurchaseAmount(read());
    }

    private IssuedLotto issueLotto(PurchaseAmount purchaseAmount) {
        IssuedLotto issuedLotto = lottoIssueService.issueLotto(purchaseAmount);
        Writer.printIssuedLottoList(issuedLotto);
        return issuedLotto;
    }

    private WinningNumber inputWinningNumber() {
        Writer.inputWinningNumber();
        return WinningNumber.saveWinningNumbers(read());
    }

    private BonusNumber inputBonusNumber() {
        Writer.inputBonusNumber();
        return BonusNumber.saveBonusNumber(read());
    }

    private String read() {
        return Console.readLine();
    }

}
