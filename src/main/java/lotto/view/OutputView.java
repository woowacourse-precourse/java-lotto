package lotto.view;

import lotto.model.enumeration.Reward;

import java.util.List;

public class OutputView {

    private static final String WRITE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WRITE_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String WRITE_BONUS = "\n보너스 번호를 입력해 주세요.";

    public static void printLottoStart() {
        System.out.println(WRITE_PURCHASE_AMOUNT);
    }

    public static void printNumberOfLotto(int inputMoney) {
        System.out.println("\n" + (inputMoney/1000) + "개를 구매했습니다.");
    }

    public static void printRandomNumbers(List<List<Integer>> computerRandomNumbers) {
        for (int i = 0; i < computerRandomNumbers.size(); i++) {
            System.out.println(computerRandomNumbers.get(i));
        }
    }

    public static void printLottoNumbers() {
        System.out.println(WRITE_LOTTO);
    }

    public static void printBonusNumber() {
        System.out.println(WRITE_BONUS);
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
