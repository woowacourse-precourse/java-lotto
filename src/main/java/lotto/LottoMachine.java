package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    ArrayList<Lotto> lottoReceipt = new ArrayList<>();

    int count =0;
    //makeProcess
    public int makeLottoCount(int money) {
        count = money / 1000;
        return count;
    }

    public void makeLottoReceipt() {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            Lotto lotto = new Lotto(lottoNumber);
            lottoReceipt.add(lotto);
        }
    }

    public ArrayList<Lotto> getLottoReceipt() {
        return lottoReceipt;
    }
}
