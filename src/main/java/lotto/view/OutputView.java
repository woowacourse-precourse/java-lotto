package lotto.view;

import java.util.List;

public class OutputView {

    public static void OutputIssueLotto(int count, List<List<Integer>> userLotto) {
        System.out.println(count+"개를 구매했습니다.");
        for (int c=0; c<count; c++) {
            System.out.println(userLotto.get(c));
        }
    }
}
