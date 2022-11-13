package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoMessage;
import lotto.LottoService;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final LottoMessage lottoManager = new LottoMessage();

    public void purchase() {
        lottoManager.printPurchaseMessage();
        Money money = new Money(Console.readLine());
        List<Lotto> lotteries = lottoService.purchase(money);
    }
}
