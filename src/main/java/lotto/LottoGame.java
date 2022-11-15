package lotto;

import lotto.util.StringParsingUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LottoGame {
    private static final String LOTTO_NUMBER_IS_DUPLICATED = "[ERROR] 중복된 번호가 당첨 번호에 있습니다.";
    private static final int MONEY_UNIT = 1000;
    private final int amount;
    private int bonusNumber;
    private Lottos lottos;
    private Lotto winningLotto;
    private Map<Rank, Integer> statistics;

    public LottoGame(int money) {
        this.amount = getLottoAmount(new Money(money));
        this.statistics = new TreeMap<>(Collections.reverseOrder());
    }

    public void start() {
        this.lottos = Lottos.generateLottos(amount);
        OutputView.printLottoCount(lottos);
        OutputView.printLottos(lottos);
        OutputView.printWinningLottoNumberMessage();
        this.winningLotto = new Lotto(StringParsingUtils.parseToNumber(InputView.inputWinningLotto()));
        OutputView.printBonusNumberMessage();
        this.bonusNumber = validateBonusNumber(InputView.inputBonusNumber());
        OutputView.printGameStatistics();
        Map<Rank, Integer> result = calculateRankStatistics(winningLotto, bonusNumber);
        OutputView.printStatistics(result);
        OutputView.printEarningRate(calculateEarningRate());
    }

    private String calculateEarningRate() {
        double earning = 0;
        int money = amount * 1000;

        for (Rank rank : statistics.keySet()){
            int matchCount = statistics.get(rank);
            int reward = rank.getReward();
            earning += matchCount * reward;
        }

        return String.format("%.1f", (earning / money) * 100);
    }

    private Map<Rank, Integer> calculateRankStatistics(Lotto winningLotto, int bonusNumber) {
        initRankStatistics();
        statistics = lottos.compareWithWinningLotto(statistics, winningLotto, bonusNumber);
        return statistics;
    }

    private void initRankStatistics() {
        for (int i = 0; i < Rank.values().length; i++) {
            statistics.put(Rank.values()[i], 0);
        }
    }

    private int validateBonusNumber(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            System.out.println(LOTTO_NUMBER_IS_DUPLICATED);
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATED);
        }
        return bonusNumber;
    }

    private int getLottoAmount(Money money) {
        return money.getMoney() / MONEY_UNIT;
    }
}