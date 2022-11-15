package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.ui.Input;
import lotto.ui.Output;

public class LottoGame {
    private final LottoConverter numbersConverter;
    private final LottoGenerator numbersGenerator;
    private final LottoCalculator lottoCalculator;

    private final Input input;
    private final Output output;

    public LottoGame() {
        numbersConverter = new LottoConverter();
        numbersGenerator = new LottoGenerator();
        lottoCalculator = new LottoCalculator();
        input = new Input();
        output = new Output();
    }

    public void run() {
        try {
            long playerMoney = numbersConverter.convertMoney(input.scanMoney());
            long playerLottoQuantity = lottoCalculator.getLottoQuantity(playerMoney);

            List<Lotto> playerLotto = numbersGenerator.getLottos(playerLottoQuantity);
            output.printPlayerLotto(playerLottoQuantity, playerLotto);

            List<Integer> winningLotto = numbersConverter.convertScanNumbersToWinningNumbers(input.scanNumbers());
            int bonusNumber = numbersConverter.convertBonus(input.scanBonus());

            Map<Integer, Integer> resultBoard = getStatistic(winningLotto, bonusNumber, playerLotto);
            output.printStatistic(resultBoard);

            long rewardMoney = lottoCalculator.getRewardMoney(resultBoard);
            double rate = lottoCalculator.getRate(rewardMoney, playerMoney);
            output.printRate(rate);
        }catch (IllegalArgumentException e){
            output.printMessage(e.getMessage());
        }
    }

    private Map<Integer, Integer> getStatistic(List<Integer> winningNumbers, int bonusNumber, List<Lotto> playerLotto) {
        Map<Integer, Integer> resultMap = new HashMap<>() {{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
        }};
        for (Lotto lotto : playerLotto) {
            int equalsCount = lottoCalculator.getEqualsCount(winningNumbers, bonusNumber, lotto);
            if (equalsCount >= 3) {
                int rank = lottoCalculator.getRank(equalsCount);
                resultMap.put(rank, resultMap.get(rank) + 1);
            }
        }
        return resultMap;
    }
}
