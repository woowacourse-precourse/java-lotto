package lotto.view;

import lotto.domian.lotto.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    LottoView lottoView = new LottoView();
    List<List<Integer>> lottos = new ArrayList<>();
    private int money;

    public void buyNewLottos() {
        money = lottoView.getMoney();
        System.out.println();
        printLottosNumbers(money / 1000);
    }

    public void printLottosNumbers(int count) {
        System.out.println(count + "개를 구매했습니다.");
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottos = lottoGenerator.generateLotto(count);
        for (List lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
