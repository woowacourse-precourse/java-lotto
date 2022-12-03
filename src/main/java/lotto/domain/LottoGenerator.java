package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    static List<List<Integer>> myLotto = new ArrayList<>();

    public static void generateLotto(PurchaseAmount purchaseAmount){
        for(int i=0;i<purchaseAmount.getNumberOfLotto();i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            myLotto.add(numbers);
        }
    }
}
