package lotto.view;

import lotto.model.enumeration.Reward;

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


    public static void printStatistics(int[] result) {
        System.out.println("\n당첨 통계\n" + "---");

        for (int i = 0; i < result.length; i++) {
            System.out.println(Reward.values()[i].getMessage() + result[i] + "개");
        }
    }

    public static void printRate(String rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
