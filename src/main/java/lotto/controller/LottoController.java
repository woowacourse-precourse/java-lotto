package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoController {
    List<Lotto> lottoList = new ArrayList<>();
    public void makeLottoList(int publicians) {
        for (int i = 0; i < publicians; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }

}
