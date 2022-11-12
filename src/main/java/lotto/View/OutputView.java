package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class OutputView {
    public void printTotal(List<Lotto> totalLotto) {
        System.out.println(totalLotto.size() + "개를 구매했습니다.");
        
        for (Lotto lotto : totalLotto) {
            System.out.println(lotto.toString());
        }
    }
}
