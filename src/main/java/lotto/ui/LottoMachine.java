package lotto.ui;

import lotto.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoMachine {
    InputScanner scanner = new InputScanner();
    List<Lotto> lottos = new ArrayList<>();
    LottoComparator lottoComparator;
    Map<String, Integer> lottoComparisonResults = new HashMap<>(Map.of("fifthPlace", 0,
            "fourthPlace", 0,
            "thirdPlace", 0,
            "secondPlace", 0,
            "firstPlace", 0));

    public LottoMachine() {
    }

    public void start() {
        purchaseLottos();
        Printer.printPurchasedLottos(lottos);
        Printer.requestWinningNumber();
        List<Integer> winningNumbers = scanner.scanWinningNumbers();

        Printer.requestBonusNumber();
        int bonusNumber = scanner.scanBonusNumber();
        lottoComparator = new LottoComparator(lottos, winningNumbers, bonusNumber);
        compareLottos();
        calculateTotalWinningAmount();
    }

    private void purchaseLottos() {
        int lottoCount = scanner.scanPurchaseAmount();
        Printer.requestLottoCount(lottoCount);
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomNumbers());
            lottos.add(lotto);
        }
    }

    private void compareLottos() {
        putKeyValue();
        Printer.requestMatchResults(lottoComparisonResults);
    }

    private void putKeyValue() {
        lottoComparisonResults.put("fifthPlace", lottoComparator.getNumberMatchesLottoNumber(3));
        lottoComparisonResults.put("fourthPlace", lottoComparator.getNumberMatchesLottoNumber(4));
        lottoComparisonResults.put("thirdPlace", lottoComparator.getNumberMatchesLottoNumber(5));
        int secondPlaceCount = lottoComparator.getNumberMatchesLottoNumber(5, true);
        //2등과 3등의 중복당첨을 피하기 위한 조치
        lottoComparisonResults.put("secondPlace", secondPlaceCount);
        lottoComparisonResults.put("thirdPlace", lottoComparisonResults.get("thirdPlace") - secondPlaceCount);
        lottoComparisonResults.put("firstPlace", lottoComparator.getNumberMatchesLottoNumber(6));
    }

    private void calculateTotalWinningAmount() {
        AtomicInteger totalWinningAmount = new AtomicInteger();
        Map<String, Integer> prizes = new HashMap<>(Map.of("fifthPlace", 5_000,
                "fourthPlace", 50_000,
                "thirdPlace", 1_500_000,
                "secondPlace", 30_000_000,
                "firstPlace", 2_000_000_000));
        lottoComparisonResults.forEach((key, value) -> {
            totalWinningAmount.addAndGet(prizes.get(key) * value);
        });
        double margin = lottoComparator.calculateMargin(totalWinningAmount);
        Printer.requestMargin(margin);
    }
}
