package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class GetLotto {
    private final int price = 1000;
    private final List<List<Integer>> get_lotto = new ArrayList<>();
    private final int lotto_count;
    private final int START_NUM = 1;
    private final int END_NUM = 45;
    private final int PICK_NUM = 6;
    public GetLotto(int money){
        this.lotto_count = money / price;
        output_lotto(lotto_count);
    }

    public void output_lotto(int lotto_count) {
        for(int i = 0; i < lotto_count; i++) {
            List<Integer> issuance = new ArrayList<>();
            issuance.addAll(Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, PICK_NUM));
            Collections.sort(issuance);
            get_lotto.add(issuance);
            System.out.println(issuance);
        }
    }
}
