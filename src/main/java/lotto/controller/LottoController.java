package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoMessage;
import lotto.LottoService;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final LottoMessage lottoMessage = new LottoMessage();

    public void purchase() {
        lottoMessage.printPurchaseMessage();
        Money money = new Money(Console.readLine());
        lottoService.purchase(money);
    }

    public void showPurchaseLotteries() {
        List<Lotto> purchaseLotteries = lottoService.getPurchaseLotteries();
        lottoMessage.printPurchasedLotteries(purchaseLotteries);
    }

    public void inputWinningNumber() {
        lottoMessage.printInputWinningNumber();
        String winningNumber = Console.readLine();
        lottoMessage.printInputBonusNumber();
        String bonusNumber = Console.readLine();

        lottoService.setWinningNumber(winningNumber, bonusNumber);
    }
}
