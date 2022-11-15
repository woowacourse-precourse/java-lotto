package lotto;

import lotto.domain.Lotto;
import lotto.domain.Match;
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
    }

    private void makeWinningLotto(String numbers) {
        String[] lottoNumbers = numbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s: lottoNumbers) {
            winningNumbers.add(Integer.parseInt(s));
        }
        this.winningLotto = new Lotto(winningNumbers);
    }

    private void makeBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void getResult() {
        Map<String, Integer> matchCount = matchLotto();
        OutputView.printStartResultMessage();
        OutputView.printResult(matchCount);
    }

    public Map<String, Integer> matchLotto() {
        Map<String, Integer> matchCount = makeDefaultCount(new HashMap<String, Integer>());

        for (Lotto lotto: this.lottos) {
            List<Integer> result = matchEachLotto(lotto);
            int count = result.get(0);
            int bonusCount = result.get(1);

            matchCount = makeMatchCount(matchCount, count, bonusCount);
        }

        return matchCount;
    }

    private Map<String, Integer> makeDefaultCount(Map<String, Integer> matchCount) {
        for (Match match: Match.values()) {
            if (match.getBonus()) {
                matchCount.put(String.valueOf(match.getMatchCount()) + "+", 0);
                continue;
            }
            matchCount.put(String.valueOf(match.getMatchCount()), 0);
        }

        return matchCount;
    }

    private Map<String, Integer> makeMatchCount(Map<String, Integer> matchCount, int count, int bonusCount) {
        if (count == 5 && bonusCount == 1) {
            matchCount.put("5+", matchCount.get("5+") + 1);

            return matchCount;
        }
        if (count >= 3) {
            matchCount.put(String.valueOf(count), matchCount.get(String.valueOf(count)) + 1);
        }

        return matchCount;
    }

    private List<Integer> matchEachLotto(Lotto lotto) {
        int count = 0;
        int bonusCount = 0;

        for (Integer number: lotto.getNumbers()) {
            if (this.winningLotto.getNumbers().contains(number)) {
                count += 1;
            }
            if (this.bonusNumber == number) {
                bonusCount = 1;
            }
        }

        return List.of(count, bonusCount);
    }
}
