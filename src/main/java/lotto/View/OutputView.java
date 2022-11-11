package lotto.View;

import lotto.Lotto;
import lotto.Prize;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void printMyLottoInfo(List<Lotto> myLottos) {
        int quantity = myLottos.size();
        System.out.println(quantity + "개를 구매했습니다.");
        for (Lotto lotto : myLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(HashMap<Prize, Integer> state, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", state.get(Prize.FIFTH)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", state.get(Prize.FOURTH)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", state.get(Prize.THIRD)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", state.get(Prize.SECOND)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", state.get(Prize.FIRST)));
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
