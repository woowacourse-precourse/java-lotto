package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    public List<List<Integer>> createLotto(int lottoCount) {
        List<List<Integer>> totalLotteries = new ArrayList<>();
        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> lottery =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottery = sortLottoNumbersByASC(lottery);
            totalLotteries.add(lottery);
        }
        return totalLotteries;
    }

    public List<Integer> sortLottoNumbersByASC(List<Integer> lottery) {
        TreeSet<Integer> lotterySet = new TreeSet<>(lottery);
        for (int num : lottery) {
            lotterySet.add(num);
        }
        List<Integer> numbersList = List.copyOf(lotterySet);
        return numbersList;
    }
}