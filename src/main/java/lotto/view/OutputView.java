package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_PHRASE = "개를 구매했습니다.";

    public static void showLottoNumber(List<Lotto> lottos) {
        System.out.println(Integer.toString(lottos.size()).concat(PURCHASE_PHRASE));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void result(List<Rank> ranks, double yield) {

        for (Rank rank : ranks) {
            System.out.println(rank.toString());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ").append(yield).append("%입니다.");
        System.out.println(sb.toString());
    }
}
