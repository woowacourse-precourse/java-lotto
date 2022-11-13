package lotto.view.output;

import java.util.List;

public class LottoGeneratorView {

    public LottoGeneratorView(List<List<Integer>> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
