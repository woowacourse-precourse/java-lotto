package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoService {
    private final LottoManager lottoManager = new LottoManager();

    public void purchase() {
        lottoManager.printPurchaseMessage();
        Money money = new Money(Console.readLine());
    }
}
