package lotto.presentation;

import lotto.domain.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.LottoGenerator;
import lotto.domain.RewardCalculator;

import java.util.List;

public class LottoGame {
    private final int startNumber = 1;
    private final int endNumber = 45;
    private final int numberCount = 6;
    private final int priceUnit = 1000;
    private final LottoGenerator lottoGenerator;
    private final LottoForm lottoForm;
    private final LottoComparator lottoComparator;
    private final RewardCalculator rewardCalculator;
    private final LottoPrinter lottoPrinter;

    public LottoGame() {
        lottoForm = new LottoForm();
        lottoComparator = new LottoComparator();
        rewardCalculator = new RewardCalculator();
        lottoPrinter = new LottoPrinter();
        lottoGenerator = new LottoGenerator(startNumber, endNumber, numberCount, priceUnit, lottoPrinter);
    }

    public void play() throws IllegalArgumentException {
        int price = lottoForm.inputPrice();
        List<Lotto> lottos = lottoGenerator.createLottos(price);
        lottoPrinter.printLottos(lottos);
    }
}