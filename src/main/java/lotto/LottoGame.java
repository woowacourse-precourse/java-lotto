package lotto;

import static lotto.io.Message.ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Config;
import lotto.domain.BonusNumber;
import lotto.domain.IssuedLotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.io.Writer;
import lotto.service.LottoIssueService;

public class LottoGame {

    private final LottoIssueService lottoIssueService;

    private LottoGame(LottoIssueService lottoIssueService) {
        this.lottoIssueService = lottoIssueService;
    }

    public static void run() {
        try {
            Config config = new Config();
            LottoGame lottoGame = new LottoGame(config.lottoIssueService());
            lottoGame.start();
        } catch (NumberFormatException e) {
            Writer.sendErrorMessage(ONLY_NUMBER);
        } catch (IllegalArgumentException e) {
            Writer.sendErrorMessage(e.getMessage());
        }
    }

    public void start() {
        Writer.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(read());

        IssuedLotto issuedLotto = lottoIssueService.issueLotto(purchaseAmount);
        Writer.printIssuedLottoList(issuedLotto);

        Writer.inputWinningNumber();
        WinningNumber winningNumber = WinningNumber.saveWinningNumbers(read());

        Writer.inputBonusNumber();
        BonusNumber bonusNumber = BonusNumber.saveBonusNumber(read());

    }

    private String read() {
        return Console.readLine();
    }

}
