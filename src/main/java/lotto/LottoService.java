package lotto;

import java.util.ArrayList;

public class LottoService {

    private final LottoBot lottoBot = new LottoBot();
    private final Player player = new Player(lottoBot);
    private final ArrayList<Lotto> purchasedLotto = new ArrayList<>();

    public void startLotto() {
        purchaseLotto();
        selectWinningNumbers();
        selectBonusNumber();
        notifyResult();
    }

    private void purchaseLotto() {
        ConsoleMessage.START.printMsg();
        int lottoCount = 0;
        try {
            lottoCount = player.getLottoCountPurchased();
        } catch (IllegalArgumentException e) {
            purchaseLotto();
            return;
        }

        createAllLotto(lottoCount);
        ConsoleMessage.PURCHASE.printMsg(purchasedLotto);
    }

    private void createAllLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoBot.createLotto();
            purchasedLotto.add(lotto);
        }
    }

    private void selectWinningNumbers() {
        ConsoleMessage.WINNING_NUMBER.printMsg();
        try {
            player.selectWinningNumbers();
        } catch (IllegalArgumentException e) {
            selectWinningNumbers();
            return;
        }
    }

    private void selectBonusNumber() {
        ConsoleMessage.BONUS_NUMBER.printMsg();
        try {
            player.selectBonusNumber();
        } catch (IllegalArgumentException e) {
            selectBonusNumber();
            return;
        }
    }

    private void notifyResult() {
        int[] ranks = lottoBot.calculateRanks(purchasedLotto);
        ConsoleMessage.RESULT.printMsg(ranks);

        double yield = lottoBot.calculateYield(ranks);
        ConsoleMessage.YIELD.printMsg(yield);
    }
}
