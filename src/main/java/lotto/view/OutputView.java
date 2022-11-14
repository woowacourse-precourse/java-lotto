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
    public static void FourthLotto(int count) {
        System.out.println("4개 일치 (50,000원) - "+count+"개");
    }
    public static void ThirdLotto(int count) {
        System.out.println("5개 일치 (1,500,000원) - "+count+"개");
    }
    public static void SecondLotto(int count) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+count+"개");
    }
}
