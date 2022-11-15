package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import model.Lotto;
import view.LottoUI;

public class LottoController {
    private static Lotto model;
    private static LottoUI view;

    public static void makeLottery(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45,6);
        model = new Lotto(numbers);
    }
    public static Lotto getLottery(){
        return model;
    }

}
