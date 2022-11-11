package lotto;

import java.util.EnumMap;
import java.util.List;

import static lotto.LottoConstant.*;

public class LottoProgram {
    private LottoStore lottoStore;
    private WinningLotto winningLotto;
    private EnumMap<WinningType, Integer> winningResult;

    public LottoProgram() {
        lottoStore = new LottoStore();
        winningResult = new EnumMap<>(WinningType.class);
        winningLotto = null;

        for (WinningType type : WinningType.values()) {
            winningResult.put(type, INIT_WINNING_COUNT);
        }
    }

    public void run() {
        LottoSeller lottoSeller = new LottoSeller();

        buyLotto(lottoSeller.receivePurchasePrice());
        initializeWinningLotto();

        LottoWinningAnalyzer analyzer = new LottoWinningAnalyzer(winningResult);

        analyzer.printWinningResult();
        analyzer.printProfit(lottoStore.getUserPaidMoney());
    }

    public void buyLotto(int price) {
        lottoStore.buyLottoNumber(price);
    }

    private void initializeWinningLotto() {
        LottoSeller lottoSeller = new LottoSeller();
        this.winningLotto = lottoSeller.createWinningLotto();
        initializeWinningResult();
    }

    private void initializeWinningResult() {
        List<Lotto> lottoTickets = lottoStore.getLottoTickets();

        for (int i = 0; i < lottoTickets.size(); i++) {
            Lotto lottoTicket = lottoTickets.get(i);
            int count = winningLotto.countWinningNumber(lottoTicket);
            boolean hasBonus = winningLotto.hasNumberInBonus(lottoTicket);

            updateWinningResult(count, hasBonus);
        }
    }

    private void updateWinningResult(int count, boolean hasBonus) {
        if (count == WINNING_THREE_NUM) {
            addWinningResult(WinningType.THREE);
            return;
        }

        if (count == WINNING_FOUR_NUM) {
            addWinningResult(WinningType.FOUR);
            return;
        }

        if (count == WINNING_FIVE_NUM) {
            if (hasBonus) {
                addWinningResult(WinningType.FIVE_AND_BONUS);
                return;
            }
            addWinningResult(WinningType.FIVE);
            return;
        }

        if (count == WINNING_SIX_NUM) {
            addWinningResult(WinningType.SIX);
            return;
        }
    }

    private void addWinningResult(WinningType type) {
        int currentCount = winningResult.get(type).intValue();
        winningResult.put(type, currentCount + PLUS_ONE_COUNT);
    }
}
