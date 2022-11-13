package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.InputView.inputPurchase;

public class Lottos {

    private List<Integer> createSingleRandomLotto() {
        List<Integer> lotto = new ArrayList<>();
        lotto= Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);
        return lotto;

    }

    public List<List<Integer>> createRandomLottos() {
        int purchase = inputPurchase();
        int n= purchase/1000;
        List<List<Integer>> lottos = new ArrayList<>();

        for(int i=0;i<n;i++){
            lottos.add(createSingleRandomLotto());
        }
        return lottos;
    }
}
