package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoTicket;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private static LottoService lottoService;
    private Input input;

    public LottoController(LottoService lottoService, Input input) {
        this.lottoService = lottoService;
        this.input = input;
    }

    public void start() {
        try {
            Money money = suggestMoney();
            LottoList lottoList = createLottoList(money);
            User user = lottoUser(money);
            printStatistics(lottoList, user);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private LottoList createLottoList(Money money) {
        LottoList lottoList = lottoService.createLottoList(money);
        printLottoList(lottoList);
        return lottoList;
    }

    private Money suggestMoney() {
        Output.printMoneyInputMessage();
        Money money = input.getMoney();
        Output.printPurchaseLottoMessage(money.lottoCount());
        return money;
    }

    private void printStatistics(LottoList lottoList, User user) {
        WinningLottoTicket winningLottoTicket = lottoService.getWinningLottoTicket(user, lottoList);
        printResult(user, winningLottoTicket);
    }

    private void printLottoList(LottoList lottoList) {
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private void printResult(User user, WinningLottoTicket winningLottoTicket) {
        Map<WinningLotto, Integer> winningLottoCount = winningLottoTicket.getWinningLottoCount();
        Output.printStatistic();
        Output.printWinningLotto(winningLottoCount);
        Output.printProfit(lottoService.calculateProfit(user, lottoService.getSum(winningLottoCount)));
    }

    private User lottoUser(Money money) {
        List<Integer> winningNumber = input.getWinningNumber();
        Integer bonusNumber = input.getBonusNumber();
        User user = new User(money, winningNumber, bonusNumber);
        return user;
    }
}
