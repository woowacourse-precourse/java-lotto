package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<List<Integer>> userLottos = new ArrayList<>();

    private int countLotto(int price) {
        return price / 1000;
    }

    private void issueLotto(int price) {
        int lottoNum;
        LottoGenerator lottoGenerator = new LottoGenerator();

        lottoNum = countLotto(price);
        for (int count = 0; count < lottoNum; count++){
            List<Integer> lotto = lottoGenerator.createRandomLotto();
            userLottos.add(lotto);
        }
    }
}