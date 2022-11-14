package lotto.view;

import java.util.List;

public class OutputView {

    public static void OutputIssueLotto(int count, List<List<Integer>> userLotto) {
        System.out.println(count+"개를 구매했습니다.");
        for (int c=0; c<count; c++) {
            System.out.println(userLotto.get(c));
        }
    }
    public static void OutputWinLotto() {
        System.out.println("당첨 통계\n---");
    }
    public static void FifthLotto(int count) {
        System.out.println("3개 일치 (5,000원) - "+count+"개");
    }
}
