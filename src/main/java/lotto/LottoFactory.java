package lotto;

import util.RandomNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    public static List<Lotto> newLottoList(int size) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> pickRandomUniqueNumbers = RandomNumbers.pickRandomUniqueNumbers(Lotto.LOTTO_SIZE);
            Collections.sort(pickRandomUniqueNumbers);
            Lotto lotto = new Lotto(pickRandomUniqueNumbers);
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
