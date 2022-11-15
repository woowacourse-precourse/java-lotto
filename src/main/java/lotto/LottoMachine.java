package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    public List<List<Integer>> createLotto(int lottoCount) {
        List<List<Integer>> totalLotteries = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers = sortLottoNumbers(numbers);
            totalLotteries.add(numbers);
        }
        return totalLotteries;
    }

    public List<Integer> sortLottoNumbers(List<Integer> numbers) {
        TreeSet<Integer> lottery = new TreeSet<>(numbers);
        for (int num : numbers) {
            lottery.add(num);
        }
        List<Integer> numbersList = List.copyOf(lottery);
        return numbersList;
    }
}