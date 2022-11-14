package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.*;
import lotto.model.*;
import lotto.model.enums.GameMessage;
import lotto.view.InputView;

public class LottoController {
    private Lotto lotto;
    private LuckySix luckySix;
    private LuckyBonus luckyBonus;
    private WinningResult winningResult;

    public void start() {
        buyLotto();
        showDrawNumber();
        pickLuckySix();
        pickLuckyBonus();
        showWinningResult();
        showProfit();
    }

    private void buyLotto() {
        String inputPrice = InputView.buyLotto();
        Price userPrice = new Price(inputPrice);
    }

    private void showDrawNumber() {
        System.out.println(ticketAmount + GameMessage.PURCHASE_MESSAGE.getMessage());
        DrawNumber userDrawNumber = new DrawNumber(ticketAmount);
    }

    private void pickLuckySix() {
        System.out.println(GameMessage.LUCKY_NUMBER_MESSAGE.getMessage());
        String inputLuckySix = Console.readLine();
        LuckySix userLuckySix = new LuckySix(inputLuckySix);
    }

    private void pickLuckyBonus() {
        System.out.println(GameMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String inputLuckyBonus = Console.readLine();
        LuckyBonus userLuckyBonus = new LuckyBonus(inputLuckyBonus);
    }

    private void showWinningResult() {
        WinningResult userWinning = new WinningResult(ticketAmount);
    }

    private void showProfit() {
        Profit userProfit = new Profit(ticketAmount * 1000);
    }


}
