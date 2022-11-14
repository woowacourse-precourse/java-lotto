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
        int bonusNumber, purchasePrice;

        purchasePrice = receivePurchasePrice();
        buyLotto(purchasePrice);
        numbers = receiveWinningNumbers();
        bonusNumber = receiveBonusNumber();

        initializeWinningLotto(numbers, bonusNumber);
        initializeWinningResult();

        printWinningResult(purchasePrice);
    }

    private void printWinningResult(int purchasePrice) {
        LottoWinningAnalyzer analyzer = new LottoWinningAnalyzer(winningResult);

        analyzer.printWinningResult();

        analyzer.printProfit(purchasePrice);
    }

    private void buyLotto(int price) {
        LottoStore lottoStore = new LottoStore();

        this.lottoTickets = lottoStore.buyLottoNumber(price);
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

            if (count >= WINNING_THREE_NUM)
                updateWinningResult(count);
        }
    }

    private void updateWinningResult(int count) {
        WinningType type = winningResult.keySet().stream().
                filter(winningType -> winningType.getWinningNumber() == count)
                .findAny()
                .get();
        int currentCount = winningResult.get(type);

        winningResult.put(type, currentCount + PLUS_ONE_COUNT);
    }
}
