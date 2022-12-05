package lotto.view;

import java.util.List;

import static lotto.util.message.OutputMessage.OUTPUT_MY_LOTTO;
import static lotto.util.message.OutputMessage.OUTPUT_RATE;
import static lotto.util.message.OutputMessage.OUTPUT_RESULT_MESSAGE;

public class OutputView {
    public static void printMyLotto(List<List<Integer>> myLotto) {
        System.out.println();
        System.out.printf(OUTPUT_MY_LOTTO.get(), myLotto.size());
        for (List<Integer> lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public static void printResult(StringBuilder resultMessage) {
        System.out.printf(OUTPUT_RESULT_MESSAGE.get());
        System.out.printf(resultMessage.toString());
    }

    public static void printRate(float rate) {
        System.out.printf(OUTPUT_RATE.get(), rate);
    }
}
