package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoException {

    public LottoException() {
    }

    public void exceptionLottoByDuplicatedNumber(List<Integer> computerLotto) {
        HashSet<Integer> LottoHashSet = new HashSet<Integer>(computerLotto);
        for (Integer integer : LottoHashSet) {
            System.out.println(integer);
        }
    }
}
