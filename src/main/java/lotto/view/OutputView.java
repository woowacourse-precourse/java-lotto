package lotto.view;

import lotto.domain.Prize;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printMyLotto(List<List<Integer>> myLotto) {
        System.out.println();
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public static void printResult(EnumMap<Prize, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        for (Map.Entry<Prize, Integer> e : result.entrySet()) {
            DecimalFormat decFormat = new DecimalFormat("###,###");
            String str = decFormat.format(e.getKey().money);
            if (e.getKey().sameNumbers == 7) {
                System.out.println("5개 일치, 보너스 볼 일치 (" + str + "원) - " + e.getValue() + "개");
            }
            if (e.getKey().sameNumbers != 7) {
                System.out.println(e.getKey().sameNumbers + "개 일치 (" + str + "원) - " + e.getValue() + "개");
            }
        }
    }

    public static void printRate(float rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

}
