package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoProgram {
    private final int LOTTO_PRICE = 1000;

    private int numberOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;
    private double rateOfReturn;

    public void progress() {
        buyLotto();
        makeLotto();
        getWinningLottoNumbers();
        getResult();
    }

    public void buyLotto() {
        OutputView.printInputMoneyMessage();

        String input = InputView.getMoney();
        int money = Integer.parseInt(input);
        this.numberOfLotto = countLottoQuantity(money);

        OutputView.printNumberOfLottoMessage(this.numberOfLotto);
    }

    public int countLottoQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    public void makeLotto() {
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> numbers = LottoGenerator.generateLotto();
            Lotto lotto = new Lotto(numbers);
            lotto.printLottoNumbers();
            this.lottos.add(lotto);
        }
    }

    public void getWinningLottoNumbers() {
        OutputView.printInputWinningNumbersMessage();
        makeWinningLotto(InputView.getLottoNumbers());

        OutputView.printInputBonusNumbersMessage();
        makeBonusNumber(InputView.getBonusNumber());
        Validation.checkDuplicateLottoNumbersAndBonusNumber(this.winningLotto.getNumbers(), this.bonusNumber);
    }

    private void makeWinningLotto(String numbers) {
        String[] lottoNumbers = numbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : lottoNumbers) {
            winningNumbers.add(Integer.parseInt(s));
        }
        this.winningLotto = new Lotto(winningNumbers);
    }

    private void makeBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void getResult() {
        Map<String, Integer> ranking = rank();
        OutputView.printStartResultMessage();
        OutputView.printResult(ranking);
        OutputView.printRateOfReturn(this.rateOfReturn);
    }

    public Map<String, Integer> rank() {
        Map<String, Integer> ranking = makeDefaultCount(new HashMap<>());

        for (Lotto lotto : this.lottos) {
            int[] result = rankEachLotto(lotto);
            int count = result[0];
            int bonusCount = result[1];

            ranking = makeRanking(ranking, count, bonusCount);
        }
        calculateRateOfReturn(ranking);

        return ranking;
    }

    private Map<String, Integer> makeDefaultCount(Map<String, Integer> ranking) {
        for (Rank rank : Rank.values()) {
            ranking.put(rank.name(), 0);
        }

        return ranking;
    }

    private Map<String, Integer> makeRanking(Map<String, Integer> ranking, int count, int bonusCount) {
        for (Rank rank: Rank.values()) {
            if (count == 5 && bonusCount == 1 && rank.getMatchCount() == count) {
                ranking.put(rank.name(), ranking.get(rank.name()) + 1);
                break;
            }
            if (count == rank.getMatchCount()) {
                ranking.put(rank.name(), ranking.get(rank.name()) + 1);
            }
        }

        return ranking;
    }

    private int[] rankEachLotto(Lotto lotto) {
        int count = 0;
        int bonusCount = 0;

        for (Integer number : lotto.getNumbers()) {
            if (this.winningLotto.getNumbers().contains(number)) {
                count += 1;
            }
            if (this.bonusNumber == number) {
                bonusCount = 1;
            }
        }

        return new int[]{count, bonusCount};
    }

    private void calculateRateOfReturn(Map<String, Integer> ranking) {
        int totalReward = 0;

        for (Rank rank : Rank.values()) {
            if (ranking.get(rank.name()) != 0) {
                totalReward += Integer.parseInt(rank.getReward().replace(",", ""));
            }
        }

        this.rateOfReturn = (double) totalReward / (this.numberOfLotto * 1000) * 100;
    }
}
