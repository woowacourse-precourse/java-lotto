package lotto.service;

import lotto.domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RandomLottoService {
    public static ArrayList<Lotto> randomLotteryGeneration(int number) {
        ArrayList<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(numbers);
            lotties.add(lotto);
        }
        return lotties;
    }

}
