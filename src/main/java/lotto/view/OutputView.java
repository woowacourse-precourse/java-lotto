package lotto.view;

import java.util.List;

import static lotto.util.message.OutputMessage.OUTPUT_MY_LOTTO;

public class OutputView {
    public static void myLotto(List<List<Integer>> myLotto) {
        System.out.printf(OUTPUT_MY_LOTTO.get(), myLotto.size());
        for (List<Integer> lotto : myLotto) {
            System.out.println(lotto);
        }
    }
}
