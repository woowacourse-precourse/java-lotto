package lotto;

import constant.LottoText;
import constant.Prize;

import java.util.List;
import java.util.Map;

public class Print {
    public void out(LottoText text) {
        System.out.println(text);
    }

    public <T> void out(LottoText text, T t) {
        System.out.printf(String.valueOf(text), t);
    }

    public void out(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void out(Map<Prize, Integer> statistic) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<Prize, Integer> prizeAndCount : statistic.entrySet()) {
            System.out.printf("%s - %d개\n", prizeAndCount.getKey().getDescription(), prizeAndCount.getValue());
        }
    }
}
