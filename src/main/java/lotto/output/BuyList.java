package lotto.output;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BuyList {

    public void show(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }
}
