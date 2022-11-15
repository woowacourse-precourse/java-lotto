package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
//            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private static void play() {
        Integer purchaseAmount = UserIO.inputPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchaseAmount);
        UserIO.printLottoNumbers(lottos);
        List<Integer> winningNumbers = UserIO.inputWinningNumber();
        Integer bonusNumber = UserIO.inputBonusNumber(winningNumbers);

        Map<Rank, Integer> resultMap = getResultOfAll(lottos, winningNumbers, bonusNumber);
        UserIO.printWinStat(resultMap, calculateYield(resultMap, purchaseAmount));
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Lotto> buyLottos(Integer purchaseAmount) {
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            Lotto lotto = new Lotto(getRandomNumbers());
            allLotto.add(lotto);
        }
        return allLotto;
    }

    private static Rank getResult(List<Integer> winningNumbers, Integer bonusNumber,
        List<Integer> lottoNumbers) {
        int result = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                result += 1;
            }
        }
        if (result == 6) return Rank.FIRST;
        if (result == 5 && getBonusNumberResult(bonusNumber, lottoNumbers)) return Rank.SECOND;
        if (result == 5) return Rank.THIRD;
        if (result == 4) return Rank.FOURTH;
        if (result == 3) return Rank.FIFTH;

        return Rank.NONE;
    }

    private static Map<Rank, Integer> getResultOfAll(List<Lotto> lottos,
        List<Integer> winningNumbers, Integer bonusNumber) {
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank result = getResult(winningNumbers, bonusNumber, lotto.getNumbers());
            map.put(result, map.getOrDefault(result, 0)+1);
        }

        return map;
    }

    private static boolean getBonusNumberResult(Integer bonusNumber, List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private static Double calculateYield(Map<Rank, Integer> map, Integer purchaseAmount) {
        double winAmount = 0;
        for (Rank rank : map.keySet()) {
            winAmount += rank.getPrize() * map.get(rank);
        }
        return Math.round(winAmount / purchaseAmount * 1000) / (double)10;
    }
}
