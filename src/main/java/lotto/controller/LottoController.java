package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.LottoUI;

public class LottoController {
    private Lotto model;
    private static LottoUI view;

    public void makeLottery(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45,6));
        model = new Lotto(numbers);
    }
    public Lotto getLottery(){
        return model;
    }

}
