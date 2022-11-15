package lotto.view;

import lotto.domain.Grade;

import java.util.List;

public class OutputView {
    private static final String Lotto_Purchase_Quantity_Message = "개를 구매했습니다.";
    private static final String Winning_Statistics_Message = "\n당첨 통계\n---";
    private static final String Lotto_Return_Message1 = "총 수익률은 ";
    private static final String Lotto_Return_Message2 = "%입니다.";

    public static void OutputLottoPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.println(purchaseQuantity + Lotto_Purchase_Quantity_Message);
    }

    public static void lottoNumber(List<List<Integer>> lottoNumber) {
        for (List<Integer> integers : lottoNumber) {
            System.out.println(integers.toString());
        }
    }

    public static void OutputGradeCount(List<Integer> gradeCount) {
        Grade[] grade = Grade.values();
        System.out.println(Winning_Statistics_Message);
        for (Grade g:grade) {
            System.out.println(g.getName() + gradeCount.get(g.getGradeCount()) + "개");
        }
    }

    public static void OutputLottoReturn(double totalReturns) {
        System.out.println(Lotto_Return_Message1 + String.format("%.1f", totalReturns) + Lotto_Return_Message2);

    }
}
