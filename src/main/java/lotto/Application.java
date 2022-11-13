package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoWin a = LottoWin.getInstance();
        int[] b_1 = {1000,1900};
        int[] b_2 = {1000,2000};
        int[] b_3 = {1000,2000};
        List<int[]> b = List.of(b_1,b_2,b_3);

        a.profitRateCal(b);
        System.out.println(a.getLottoNum());
    }
}
