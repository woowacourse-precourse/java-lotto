package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.PrizeOfLotto;
import lotto.model.Lotto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Machine {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private final Map<String, Integer> resultOfLottos;

    public Machine(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.resultOfLottos = new HashMap<>(Map.of(
                PrizeOfLotto.FIRST.getRank(), 0,
                PrizeOfLotto.SECOND.getRank(), 0,
                PrizeOfLotto.THIRD.getRank(), 0,
                PrizeOfLotto.FOURTH.getRank(), 0,
                PrizeOfLotto.FIFTH.getRank(), 0
        ));
    }
    public static BigInteger countNumberOfLottos(BigInteger money) {
        return money.divide(BigInteger.valueOf(1_000));
    }

    public static List<Lotto> generateLottos(BigInteger numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (BigInteger bi = BigInteger.valueOf(0);
             bi.compareTo(numberOfLottos) < 0;
             bi = bi.add(BigInteger.ONE)) {

            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedLottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(sortedLottoNumbers));
        }
        return lottos;
    }

    public Map<String, Integer> judge(List<Lotto> lottos) {
        for (Lotto lotto :
                lottos) {
            List<Integer> matchNumbers = matchWinningNumber(lotto);
            updateResultOfLottos(lotto, matchNumbers);
        }
        return resultOfLottos;
    }
    private List<Integer> matchWinningNumber(Lotto lotto) {
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers;
    }

    private void updateResultOfLottos(Lotto lotto, List<Integer> matchNumbers) {
        int matchCount = matchNumbers.size();
        if (List.of(0, 1, 2).contains(matchCount)) {
            return;
        }
        if (matchCount == 3) {
            resultOfLottos.replace(PrizeOfLotto.FIFTH.getRank(), resultOfLottos.get(PrizeOfLotto.FIFTH.getRank())+1);
            return;
        }
        if (matchCount == 4) {
            resultOfLottos.replace(PrizeOfLotto.FOURTH.getRank(), resultOfLottos.get(PrizeOfLotto.FOURTH.getRank())+1);
            return;
        }
        if (matchCount == 5) {
            checkBonusNumber(lotto, matchNumbers);
            return;
        }
        if (matchCount == 6) {
            resultOfLottos.replace(PrizeOfLotto.FIRST.getRank(), resultOfLottos.get(PrizeOfLotto.FIRST.getRank())+1);
        }
    }
    private void checkBonusNumber(Lotto lotto, List<Integer> matchNumbers) {
        if (hasBonusNumber(lotto, matchNumbers)) {
            resultOfLottos.replace(PrizeOfLotto.SECOND.getRank(), resultOfLottos.get(PrizeOfLotto.SECOND.getRank())+1);
            return;
        }
        if (!hasBonusNumber(lotto, matchNumbers)) {
            resultOfLottos.replace(PrizeOfLotto.THIRD.getRank(), resultOfLottos.get(PrizeOfLotto.THIRD.getRank())+1);
        }
    }
    private boolean hasBonusNumber(Lotto lotto, List<Integer> matchNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        lottoNumbers.removeAll(matchNumbers);
        System.out.println(lottoNumbers);
        Integer remainNumber = lottoNumbers.get(0);
        return remainNumber.equals(bonusNumber);
    }

}
