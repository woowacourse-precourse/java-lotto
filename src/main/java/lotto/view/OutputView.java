package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void printNumberofLotto(int inputMoney) {
        System.out.println("\n" + (inputMoney/1000) + "개를 구매했습니다.");
    }

    public static void printRandomNumbers(List<List<Integer>> computerRandomNumbers) {
        for (int i = 0; i < computerRandomNumbers.size(); i++) {
            Collections.sort(computerRandomNumbers.get(i));
            System.out.println(computerRandomNumbers.get(i));
        }
    }
}
