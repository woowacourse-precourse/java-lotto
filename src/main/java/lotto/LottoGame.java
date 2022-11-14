package lotto;

import static lotto.io.Message.ONLY_NUMBER;

import java.util.List;
import lotto.config.Config;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.io.Reader;
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
        PurchaseAmount purchaseAmount = new PurchaseAmount(Reader.readUserPurchaseAmount());
        List<Lotto> issuedLotto = lottoIssueService.issueLotto(purchaseAmount);


    }

}
