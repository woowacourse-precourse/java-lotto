package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Buyer;
import lotto.service.LottoService;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void run() {
        Buyer buyer = buy();
    }

    private Buyer buy() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        System.out.println();
        return lottoService.buy(money);
    }
}
