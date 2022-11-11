package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Model {
    private final int MINIMUM_LOTTO_NUMBERS = 1;
    private final int MAXIMUM_LOTTO_NUMBERS = 45;
    private final int LOTTO_NUMBERS = 6;

    public List<Integer> checkLottoNumber (List<Integer> lottoNumbers, List<List<Integer>> uncheckedLottos) {
        List<Integer> duplicatedNumbers = new ArrayList<>();

        for (List<Integer> lotto: uncheckedLottos){
            List<Integer> comparingNumbers = lotto.stream()
                    .filter(number -> lottoNumbers.contains(number))
                    .collect(Collectors.toList());

                duplicatedNumbers.add(comparingNumbers.size());
            }

        return duplicatedNumbers;
    }

    public HashMap<Integer, Integer> checkPrizeLotto (List<Integer> duplicatedNumbers, List<List<Integer>> uncheckedLottos, int bonusNumber) {
        List<Integer> prizeRankings = new ArrayList<>();

        for (int number: duplicatedNumbers) {
            prizeRankings.add(addPrizeRanking(number));
        }

        checkBonusNumber(prizeRankings, uncheckedLottos, bonusNumber);

        return makeNumberByRanking(prizeRankings);
    }

    private HashMap<Integer, Integer> makeNumberByRanking (List<Integer> prizeRankings) {
        HashMap<Integer, Integer> numberByRanking = new HashMap<>();

        for (int temp = 1; temp <= 5; temp++) {
            numberByRanking.put(temp, 0);
        }

        inputNumberByRanking(prizeRankings, numberByRanking);
        return numberByRanking;
    }

    public void checkBonusNumber(List<Integer> prizeRankings, List<List<Integer>> uncheckedLottos, int bonusNumber){
        int changedRanking;

        for (int temp = 0; temp < prizeRankings.size(); temp++) {

            if (prizeRankings.get(temp) == 3) {
                changedRanking = upRanking(uncheckedLottos.get(temp), bonusNumber);
                prizeRankings.set(temp, changedRanking);
            }
        }
    }

    private int upRanking (List<Integer> unCheckedLotto, int bonusNumber) {
        if (unCheckedLotto.contains(bonusNumber)) {
            return 2;
        }
        return 3;
    }

    private void inputNumberByRanking (List<Integer> prizeRankings, HashMap<Integer, Integer> numberByRanking) {

        for (int ranking: prizeRankings) {
            if (ranking > 0) {
                numberByRanking.put(ranking, numberByRanking.get(ranking) + 1);
            }
        }
    }

    private int addPrizeRanking(int duplicatedNumber) {
        if (duplicatedNumber == 3) return 5;
        if (duplicatedNumber == 4) return 4;
        if (duplicatedNumber == 5) return 3;
        if (duplicatedNumber == 6) return 1;
        return 0;
    }

    public List<List<Integer>> repeatGetLottoNumber(int moneyNumber) {
        List<List<Integer>> uncheckedLottos = new ArrayList<>();

        for (int temp = 0; temp < moneyNumber; temp++) {
            uncheckedLottos.add(getLottoNumber());
        }

        return uncheckedLottos;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBERS, MAXIMUM_LOTTO_NUMBERS, LOTTO_NUMBERS));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
