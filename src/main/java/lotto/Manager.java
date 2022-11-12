package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class Manager {
    private List<Lotto> lottoTable = new ArrayList<>();

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getAmount(int won) {
        if (won % Lotto.PRICE != 0 || won == 0) {
            throw new IllegalArgumentException();
        }
        return won / Lotto.PRICE;
    }

    public void purchaseLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(getRandomNumbers());
            lottoTable.add(lotto);
        }
    }

    public List<Lotto> getLottoTable() {
        return lottoTable;
    }

    public int compareLottoNumbers(Lotto purchasedLotto, Lotto winningLotto) {
        int numberOfMatches = 0;
        for (int i = 0; i < winningLotto.getNumbers().size(); i++) {
            if (purchasedLotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonunsNumber) {
        return lotto.getNumbers().contains(bonunsNumber);
    }

    public List<Integer> compareLottoTable(List<Lotto> lottoTable, Lotto winningLotto, int bonunsNumber) {
        if (hasBonusNumber(winningLotto, bonunsNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lottoTable.size(); i++) {
            int numberOfMatches = 0;
            numberOfMatches = compareLottoNumbers(lottoTable.get(i), winningLotto);
            if (numberOfMatches == 5 && hasBonusNumber(lottoTable.get(i), bonunsNumber)) {
                numberOfMatches += 10;
            }
            result.add(numberOfMatches);
        }
        return result;
    }

    public List<Integer> sumUpResult(List<Integer> result) {
        List<Integer> sumOfResult = new ArrayList<>();
        for (int i = 3; i <= 6; i++) {
            sumOfResult.add(Collections.frequency(result, i));
            if (i == 5) {
                sumOfResult.add(Collections.frequency(result, 15));
            }
        }
        return sumOfResult;
    }

    public float getRateOfReturn(List<Integer> sumOfResult) {
        float sum = 0;
        int[] prizeMoney = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
        for (int i = 0; i < sumOfResult.size(); i++) {
            sum += sumOfResult.get(i) * prizeMoney[i];
        }
        return sum / (getLottoTable().size() * Lotto.PRICE) * 100;
    }
}


