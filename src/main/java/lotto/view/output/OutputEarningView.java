package lotto.view.output;

import lotto.domain.earning.Earning;

public class OutputEarningView {

    public OutputEarningView(Earning earning) {
        System.out.println("총 수익률은 " + earning.getEarning() + "%입니다.");
    }
}
