package lotto.ui;

import lotto.Lotto;
import lotto.ui.InputScanner;
import lotto.domain.LottoComparator;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    InputScanner scanner = new InputScanner();
    List<Lotto> lottos = new ArrayList<>();
    LottoComparator lottoComparator;

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
    private void compareLottos(){
        Map<String, Integer> lottoComparisonResults = new HashMap<>(Map.of("fifthPlace", 0,
                "fourthPlace", 0,
                "thirdPlace", 0,
                "secondPlace", 0,
                "firstPlace", 0));
        lottoComparisonResults.put("fifthPlace", lottoComparator.getNumberMatchesLottoNumber(3));
        lottoComparisonResults.put("fourthPlace", lottoComparator.getNumberMatchesLottoNumber(4));
        lottoComparisonResults.put("thirdPlace", lottoComparator.getNumberMatchesLottoNumber(5));
        lottoComparisonResults.put("secondPlace", lottoComparator.getNumberMatchesLottoNumber(5, true));
        lottoComparisonResults.put("firstPlace", lottoComparator.getNumberMatchesLottoNumber(6));

        System.out.printf("3개 일치 (5,000원) - %d개%n", lottoComparisonResults.get("fifthPlace"));
        System.out.printf("4개 일치 (50,000원) - %d개%n", lottoComparisonResults.get("fourthPlace"));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", lottoComparisonResults.get("thirdPlace"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", lottoComparisonResults.get("secondPlace"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", lottoComparisonResults.get("firstPlace"));
    }
}
