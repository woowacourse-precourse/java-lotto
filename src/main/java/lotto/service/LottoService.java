package lotto.service;

import lotto.console.ConsoleMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoBot;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoBot lottoBot = new LottoBot();
    private final PlayerService playerService = new PlayerService(lottoBot);
    private final ArrayList<Lotto> purchasedLotto = new ArrayList<>();

    public void startLotto() {
        try {
            purchaseLotto();
            selectWinningNumbers();
            selectBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        notifyResult();
    }

    private void purchaseLotto() {
        ConsoleMessage.START.printMsg();
        int lottoCount = playerService.getLottoCountPurchased();

        createAllLotto(lottoCount);
        ConsoleMessage.PURCHASE.printLottoMsg(purchasedLotto);
    }

    private void createAllLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoBot.createLotto();
            purchasedLotto.add(lotto);
        }
    }

    private void selectWinningNumbers() {
        ConsoleMessage.WINNING_NUMBER.printMsg();
        playerService.selectWinningNumbers();
    }

    private void selectBonusNumber() {
        ConsoleMessage.BONUS_NUMBER.printMsg();
        playerService.selectBonusNumber();
    }

    private void notifyResult() {
        List<Integer> ranks = lottoBot.calculateRanks(purchasedLotto);
        ConsoleMessage.RESULT.printResultMsg(ranks);

        double yield = lottoBot.calculateYield(ranks);
        ConsoleMessage.YIELD.printMsg(yield);
    }
}
