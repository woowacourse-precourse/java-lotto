package lotto.controller;

import lotto.resource.MessageType;
import lotto.resource.WinningType;
import lotto.model.LottoStore;
import lotto.model.LottoWinningAnalyzer;
import lotto.model.WinningLotto;
import lotto.model.Lotto;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;

import static lotto.view.LottoSeller.*;

public class LottoProgram {
    private List<Lotto> lottoTickets;
    private EnumMap<WinningType, Integer> winningResult;
    private LottoWinningAnalyzer analyzer;

    public void run() {
        int purchasePrice = receivePurchasePrice();
        buyLotto(purchasePrice);

        printWinningResult(receiveWinningNumbers(), receiveBonusNumber());
        printProfit(purchasePrice);
    }

    private void printWinningResult(List<Integer> numbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
        NumberFormat numberFormat = NumberFormat.getInstance();

        initializeWinningResult(winningLotto);

        winningResult.forEach((key, value) -> {
            printMessage(String.format(key.getMessage(),
                    numberFormat.format(key.getMoney()), value));
        });
    }

    private void printProfit(int purchasePrice) {
        double profit = calculateProfit(purchasePrice);

        printMessage(String.format(
                MessageType.WINNING_RESULT.getMessage(), profit));
    }

    private void buyLotto(int price) {
        LottoStore lottoStore = new LottoStore();

        this.lottoTickets = lottoStore.buyLottoNumber(price);

        printLottoNumbers(lottoTickets);
    }

    private double calculateProfit(int purchasePrice) {
        return analyzer.calculateProfit(purchasePrice);
    }

    private void initializeWinningResult(WinningLotto winningLotto) {
        analyzer = new LottoWinningAnalyzer(winningLotto);
        winningResult = analyzer.calculateWinningResult(lottoTickets);
    }
}
