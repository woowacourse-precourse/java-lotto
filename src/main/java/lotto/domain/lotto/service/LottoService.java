package lotto.domain.lotto.service;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.type.PriceNumberCount;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.global.util.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public int lottoCount(int inputMoney) {
        return inputMoney / 1000;
    }

    public Lotto randomLottoNumbers() {
        return new Lotto(Util.orderByDescForList(Util.getRandomNumbers()));
    }

    public Lotto prizeLotto() {
        return new Lotto(Util.inputNumbersInList());
    }

    public int bonusNumber(Lotto prizeLotto) {
        return InputView.getInputBonusNumber(prizeLotto);
    }

    // TODO
    public void compareNumbers(List<Lotto> lottos, Lotto prizeLotto, int bonusNumber) {
        Map<String, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Map<String, Integer> howManyMatchNumber =
                    howManyMatchNumber(lotto.getNumbers(), prizeLotto.getNumbers(), bonusNumber);
            String key = keyNameForResult(howManyMatchNumber.get("prize"), howManyMatchNumber.get("bonus"));
            if (result.get(key) != null) {
                result.put(key, result.get(key) + 1);
            }
            result.putIfAbsent(key, 1);
        }
        OutputView.printResult(result);
    }

    static int prize = 0;
    static int bonus = 0;

    // TODO
    private Map<String, Integer> howManyMatchNumber(List<Integer> lotto, List<Integer> prizeLotto, int bonusNumber) {
        Map<String, Integer> countMatchNumbers = new HashMap<>();
        for (int number : lotto) {
            compareNumber(prizeLotto, number, bonusNumber);
        }
        countMatchNumbers.put("prize", prize);
        countMatchNumbers.put("bonus", bonus);
        return countMatchNumbers;
    }

    private void compareNumber(List<Integer> prizeLotto, int number, int bonusNumber) {
        for (int prizeNumber : prizeLotto) {
            if (number == prizeNumber) {
                prize++;
                break;
            }
            if (number == bonusNumber) {
                bonus++;
                break;
            }
        }
    }

    private String keyNameForResult(int prize, int bonus) {
        PriceNumberCount[] priceNumberCounts = PriceNumberCount.values();
        for (PriceNumberCount priceNumberCount : priceNumberCounts) {
            if (prize == priceNumberCount.getPrize() && bonus == priceNumberCount.getBonus()) {
                return priceNumberCount.getMessage();
            }
        }
        return "none";
    }
}
