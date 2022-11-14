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
        //여기 결과랑 수익률 계산
        notifyResult();
    }

    private void purchaseLotto() {
        ConsoleMessage.START.printMsg();
        int lottoCount = 0;
        try {
            lottoCount = player.getLottoCountPurchased();
        } catch (IllegalArgumentException e) {
            purchaseLotto();
        }

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoBot.createLotto();
            purchasedLotto.add(lotto);
        }
        ConsoleMessage.PURCHASE.printMsg(purchasedLotto);
    }

    private void selectWinningNumbers() {
        ConsoleMessage.WINNING_NUMBER.printMsg();
        try {
            player.selectWinningNumbers();
        } catch (IllegalArgumentException e) {
            selectWinningNumbers();
        }
    }

    private void selectBonusNumber() {
        ConsoleMessage.BONUS_NUMBER.printMsg();
        try {
            player.selectBonusNumber();
        } catch (IllegalArgumentException e) {
            selectBonusNumber();
        }
    }

    private void notifyResult() {
        int[] ranks = lottoBot.calculateRanks(purchasedLotto);
        ConsoleMessage.RESULT.printMsg(ranks);

        double yield = lottoBot.calculateYield(ranks);
        ConsoleMessage.YIELD.printMsg(yield);
    }
}
