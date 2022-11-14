package lotto;

import java.util.EnumMap;
import java.util.List;

import static lotto.LottoConstant.*;
import static lotto.LottoSeller.*;

public class LottoProgram {
    private List<Lotto> lottoTickets;
    private WinningLotto winningLotto;
    private EnumMap<WinningType, Integer> winningResult;

    public LottoProgram() {
        winningResult = new EnumMap<>(WinningType.class);

        for (WinningType type : WinningType.values()) {
            winningResult.put(type, INIT_WINNING_COUNT);
        }
    }

    public void run() {
        List<Integer> numbers;
        int bonusNumber;
        int purchasePrice;

        purchasePrice = receivePurchasePrice();
        this.lottoTickets = buyLotto(purchasePrice);
        numbers = receiveWinningNumbers();
        bonusNumber = receiveBonusNumber();

        initializeWinningLotto(numbers, bonusNumber);
        initializeWinningResult();

        LottoWinningAnalyzer analyzer = new LottoWinningAnalyzer(winningResult);

        analyzer.printWinningResult();
        analyzer.printProfit(purchasePrice);
    }

    public List<Lotto> buyLotto(int price) {
        LottoStore lottoStore = new LottoStore();
        return lottoStore.buyLottoNumber(price);

    }

    private void initializeWinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
    }

    public void createWinningLotto(List<Integer> numbers, int bonusNumber) {
        Lotto winningNumber = new Lotto(numbers);

        this.winningLotto = new WinningLotto(winningNumber, bonusNumber);
    }

    private void initializeWinningResult() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            Lotto lottoTicket = lottoTickets.get(i);
            int count = winningLotto.countWinningNumber(lottoTicket);
            boolean hasBonus = winningLotto.hasNumberInBonus(lottoTicket);

            updateWinningResult(count, hasBonus);
        }
    }

    private void updateWinningResult(int count, boolean hasBonus) {
        if (count == WINNING_THREE_NUM) {
            addWinningCount(WinningType.THREE);
            return;
        }

        if (count == WINNING_FOUR_NUM) {
            addWinningCount(WinningType.FOUR);
            return;
        }

        if (count == WINNING_FIVE_NUM) {
            if (hasBonus) {
                addWinningCount(WinningType.FIVE_AND_BONUS);
                return;
            }
            addWinningCount(WinningType.FIVE);
            return;
        }

        if (count == WINNING_SIX_NUM) {
            addWinningCount(WinningType.SIX);
            return;
        }
    }

    private void addWinningCount(WinningType type) {
        int currentCount = winningResult.get(type).intValue();
        winningResult.put(type, currentCount + PLUS_ONE_COUNT);
    }
}
