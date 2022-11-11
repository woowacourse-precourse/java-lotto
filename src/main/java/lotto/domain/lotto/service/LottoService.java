package lotto.domain.lotto.service;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.type.PriceNumberCount;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.domain.view.constant.UserServiceConstants;
import lotto.global.util.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.view.constant.UserServiceConstants.*;

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
            String key = getKeyForMap(lotto, prizeLotto, bonusNumber);
            putValues(result, key);
        }
        OutputView.printResult(result);
    }

    private void putValues(Map<String, Integer> result, String key) {
        if (result.get(key) != null) {
            result.put(key, result.get(key) + 1);
        }
        result.putIfAbsent(key, 1);
    }

    private String getKeyForMap(Lotto lotto, Lotto prizeLotto, int bonusNumber) {
        Map<String, Integer> howManyMatchNumber =
                howManyMatchNumber(lotto.getNumbers(), prizeLotto.getNumbers(), bonusNumber);
        return keyNameForResult(howManyMatchNumber.get(UserServiceConstants.PRIZE), howManyMatchNumber.get("bonus"));
    }

    static int PRIZE = 0;
    static int BONUS = 0;

    private Map<String, Integer> howManyMatchNumber(List<Integer> lotto, List<Integer> prizeLotto, int bonusNumber) {
        Map<String, Integer> countMatchNumbers = new HashMap<>();
        for (int number : lotto) {
            compareNumber(prizeLotto, number, bonusNumber);
        }
        countMatchNumbers.put(UserServiceConstants.PRIZE, PRIZE);
        countMatchNumbers.put(UserServiceConstants.BONUS, BONUS);
        return countMatchNumbers;
    }

    private void compareNumber(List<Integer> prizeLotto, int number, int bonusNumber) {
        for (int prizeNumber : prizeLotto) {
            if (number == prizeNumber) {
                PRIZE++;
                break;
            }
            if (number == bonusNumber) {
                BONUS++;
                break;
            }
        }
    }

    private String keyNameForResult(int prize, int bonus) {
        PriceNumberCount[] priceNumberCounts = PriceNumberCount.values();
        for (PriceNumberCount priceNumberCount : priceNumberCounts) {
            if (isExistsNumber(priceNumberCount, prize, bonus) != null) {
                return isExistsNumber(priceNumberCount, prize, bonus);
            }
        }
        return NONE;
    }

    private String isExistsNumber(PriceNumberCount priceNumberCount, int prize, int bonus) {
        if (prize == priceNumberCount.getPrize() && bonus == priceNumberCount.getBonus()) {
            return priceNumberCount.getMessage();
        }
        return null;
    }

}
