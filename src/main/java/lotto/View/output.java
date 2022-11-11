package lotto.View;

import java.util.List;

public class output {
    final static String NoticeBuyLotto = "개를 구매했습니다.";

    public static void printAmount(int amountLotto) {
        System.out.println(amountLotto + NoticeBuyLotto);
    }

    public static void printAmountLotto(List<List<Integer>> groupNumbers) {
        for (List<Integer> groupNumber : groupNumbers) {
            System.out.println(groupNumber);
        }
    }
}
