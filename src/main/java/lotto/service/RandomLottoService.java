package lotto.service;

import lotto.domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomLottoService {
    public static ArrayList<Lotto> randomLotteryGeneration(int number) {
        ArrayList<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            ArrayList<Integer> lottoNumbers = new ArrayList<>(numbers);
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lotties.add(lotto);
        }
        return lotties;
    }

}
