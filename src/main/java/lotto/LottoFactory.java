package lotto;

import util.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static List<Lotto> newLottoList(int size) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(RandomNumbers.pickRandomUniqueNumbers(6));
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
