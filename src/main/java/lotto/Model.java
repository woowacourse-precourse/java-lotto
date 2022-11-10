package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class Model {
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

    public List<Integer> checkPrizeLotto (List<Integer> duplicatedNumbers, List<List<Integer>> uncheckedLottos, int bonusNumber) {
        List<Integer> prizeRankings = new ArrayList<>();

        for (int number: duplicatedNumbers) {
            prizeRankings.add(addPrizeRanking(number));
        }

        return checkBonusNumber(prizeRankings, uncheckedLottos, bonusNumber);
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

    private List<Integer> checkBonusNumber(List<Integer> prizeRankings, List<List<Integer>> uncheckedLottos, int bonusNumber){
        int changedRanking;

        for (int rank: prizeRankings) {

            if (rank == 3) {
                changedRanking = upRanking(uncheckedLottos.get(prizeRankings.indexOf(rank)), bonusNumber);
                prizeRankings.set(prizeRankings.indexOf(rank), changedRanking);
            }
        }

        return prizeRankings;
    }

    private int upRanking (List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            return 2;
        }
        return 3;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LOTTO_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);

            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
