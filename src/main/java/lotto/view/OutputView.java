package lotto.view;

import lotto.domain.Grade;

import java.util.List;

public class OutputView {
    private static final String BUY_MESSAGE = "%d개를 구매했습니다.\n";

    public static void printGenerateLottoRepository(Integer ableCount, List<List<Integer>> lottoRepository){
        System.out.println();
        System.out.printf(BUY_MESSAGE, ableCount);

        for (List<Integer> lotto : lottoRepository){
            System.out.println(lotto);
        }
    }

}
